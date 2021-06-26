```c
#include <fcntl.h>
#include <stdio.h>
#include <errno.h>
#include <stdlib.h>
#include <string.h>
#include <dirent.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/stat.h>

char name[64] = "mysh";
int last_status;
int isBackground = 0;

// Misc
char* getCurrentPath();
char* extendCurrentPath(char* path);
char* substring(char* string, int from, int to);
int countArgs(char* input);
int isSpecialChar(char c);
int handleSpecialChar(char* input, int from, int to);
int countPipeArgs(char* input);

// Simple Commands
int cmd_name(int argc, char** tokens);
int cmd_help();
int cmd_status();
int cmd_exit(int argc, char** tokens);
int cmd_print(int argc, char** tokens);
int cmd_echo(int argc, char** tokens);
int cmd_pid();
int cmd_ppid();

// Build-In Commands (directory)
int cmd_dirchange(int argc, char** tokens);
int cmd_dirwhere();
int cmd_dirmake(int argc, char** tokens);
int cmd_dirremove(int argc, char** tokens);
int cmd_dirlist(int argc, char** tokens);

// Build-In Commands (file)
int cmd_linkhard(int argc, char** tokens);
int cmd_linksoft(int argc, char** tokens);
int cmd_linkread(int argc, char** tokens);
int cmd_linklist(int argc, char** tokens);
int cmd_unlink(int argc, char** tokens);
int cmd_rename(int argc, char** tokens);
int cmd_cpcat(int argc, char** tokens);

// Pipe Command
int cmd_pipes(int argc, char** tokens);

// Main
void checkForSpecialTokens(int argc, char** tokens);
int execute(int argc, char** tokens);
int tokenize(char* input);

int main(int argc, char* argv[]) {  
    while (!feof(stdin)) {
        int stdin_fd = dup(0);
        int stdout_fd = dup(1);

        char input[256];
        if(isatty(0)) printf("%s> ", name);
        gets(input);
        last_status = tokenize(&input[0]);
        memset(input, 0, 256);
        isBackground = 0;

        dup2(stdin_fd, 0);
        dup2(stdout_fd, 1);
    }
    
   return last_status;
}

// Implementations
int execute(int argc, char** tokens) {
    if (argc < 1) return 0;

    { // Simple Commands 
        if (!strcmp(tokens[0], "name")) return cmd_name(argc, tokens);
        if (!strcmp(tokens[0], "help")) return cmd_help();
        if (!strcmp(tokens[0], "status")) return cmd_status();
        if (!strcmp(tokens[0], "exit")) return cmd_exit(argc, tokens);
        if (!strcmp(tokens[0], "print")) return cmd_print(argc, tokens);
        if (!strcmp(tokens[0], "echo")) return cmd_echo(argc, tokens);
        if (!strcmp(tokens[0], "pid")) return cmd_pid();
        if (!strcmp(tokens[0], "ppid")) return cmd_ppid();
    }

    { // Build-In Commands (directory) 
        if (!strcmp(tokens[0], "dirchange")) return cmd_dirchange(argc, tokens); 
        if (!strcmp(tokens[0], "dirwhere")) return cmd_dirwhere(); 
        if (!strcmp(tokens[0], "dirmake")) return cmd_dirmake(argc, tokens);  
        if (!strcmp(tokens[0], "dirremove")) return cmd_dirremove(argc, tokens);
        if (!strcmp(tokens[0], "dirlist")) return cmd_dirlist(argc, tokens);
    }

    { // Build-In Commands (file)  
        if (!strcmp(tokens[0], "linkhard")) return cmd_linkhard(argc, tokens);
        if (!strcmp(tokens[0], "linksoft")) return cmd_linksoft(argc, tokens);  
        if (!strcmp(tokens[0], "linkread")) return cmd_linkread(argc, tokens); 
        if (!strcmp(tokens[0], "linklist")) return cmd_linklist(argc, tokens); 
        if (!strcmp(tokens[0], "unlink")) return cmd_unlink(argc, tokens); 
        if (!strcmp(tokens[0], "rename")) return cmd_rename(argc, tokens); 
        if (!strcmp(tokens[0], "cpcat")) return cmd_cpcat(argc, tokens); 
    }

    { // Pipe Command 
        if (!strcmp(tokens[0], "pipes")) return cmd_pipes(argc, tokens); 
    }

    int pid = fork();
    if(pid < 0) perror("fork");
    else if (pid == 0){
        execvp(tokens[0], tokens);
        perror("execvp");
        exit(1);
    }
    else if(!isBackground) {
        waitpid(pid, &last_status, 0);
    }
    return 0;
}

int tokenize(char* input) {
    int argc = countArgs(input);
    char** tokens = (char**) calloc(argc + 1, sizeof(char *));
    tokens[argc] = NULL;

    int token = -1;
    int start = -1;
    while(input[++start] == ' ');
    int len = strlen(input);

    for (int i = start; i < len; i++) {
        char el = input[i];

        if (el == '#') break;
        else if (el == ' ') {
            if (!handleSpecialChar(input, start, i)) tokens[++token] = substring(input, start, i);
            while(input[++i] == ' ');
            start = i;
            i--;
        }
        else if (el == '"') {
            start = i + 1;
            while (input[++i] != '"' && i < len - 1);
            if (!handleSpecialChar(input, start, i)) tokens[++token] = substring(input, start, i);
            while(input[++i] == ' ');
            start = i;
            i--;
        }
        else if (el == '\n' || el == '\0' || i == len - 1) {
            if (!handleSpecialChar(input, start, i + 1)) tokens[++token] = substring(input, start, i + 1);
        }
    }

    // printf("// %d args: [", argc);
    // for (int i = 0; i < argc; i++) {
    //     printf("%s", tokens[i]);
    //     if (i < argc - 1) printf(",");
    // }
    // printf("]\n");

    int status = execute(argc, tokens);

    for (int i = 0; i < argc; i++) free(tokens[i]);
    free(tokens);
    fflush(stdout);

    return status;
}

char** tokenizePipeArgs(char* input) {
    int argc = countPipeArgs(input);
    char** tokens = (char**) calloc(argc + 1, sizeof(char *));
    tokens[argc] = NULL;

    int token = -1;
    int start = -1;
    while(input[++start] == ' ');
    int len = strlen(input);

    for (int i = start; i < len; i++) {
        char el = input[i];

        if (el == ' ') {
            tokens[++token] = substring(input, start, i);
            while(input[++i] == ' ');
            start = i;
            i--;
        }
        else if (el == '\n' || el == '\0' || i == len - 1) {
            tokens[++token] = substring(input, start, i + 1);
        }
    }

    // printf("//// %d args: [", argc);
    // for (int i = 0; i < argc; i++) {
    //     printf("%s", tokens[i]);
    //     if (i < argc - 1) printf(",");
    // }
    // printf("]\n");

    return tokens;
}

char* getCurrentPath() {
    return getcwd(NULL, PATH_MAX);
}

char* extendCurrentPath(char* path) {
    if (path[0] == '/') return path;
    char* current = getCurrentPath();
    strcat(current, "/");
    strcat(current, path);
    return current;
}

char* substring(char* string, int from, int to) {
    int size = to - from;
    char* element = (char*) calloc(size, sizeof(char));
    for (int i = 0; i < size; i++) element[i] = string[from + i];
    return element;
}

int countArgs(char* input) {
    int counter = 0;
    int start = -1;
    while(input[++start] == ' ');
    int len = strlen(input);

    for (int i = start; i < len; i++) {
        char el = input[i];

        if (el == '#') break;
        else if (el == ' ') {
            if (!isSpecialChar(input[start])) counter++;
            while(input[++i] == ' ');
            start = i;
            i--;
        }
        else if (el == '"') {
            start = i + 1;
            while (input[++i] != '"' && i < len - 1);
            if (!isSpecialChar(input[start])) counter++;
            while(input[++i] == ' ');
            start = i;
            i--;
        }
        else if (el == '\n' || el == '\0' || i == len - 1) {
            if (!isSpecialChar(input[start])) counter++;
        }
    }

    return counter;
}

int countPipeArgs(char* input) {
    int counter = 0;
    int start = -1;
    while(input[++start] == ' ');
    int len = strlen(input);

    for (int i = start; i < len; i++) {
        char el = input[i];

        if (el == ' ') {
            counter++;
            while(input[++i] == ' ');
            start = i;
            i--;
        }
        else if (el == '\n' || el == '\0' || i == len - 1) {
            counter++;
        }
    }

    return counter;
}

int isSpecialChar(char c) {
    return c == '&' || c == '<' || c == '>';
}

int handleSpecialChar(char* input, int from, int to) {
    switch (input[from]) {
        case '&': {
            isBackground = 1;
            return 1;
        }

        case '<': {
            int inputFile = open(substring(input, from + 1, to), O_RDONLY);
            close(0);
            dup2(inputFile, 0);
            close(inputFile);
            return 1;
        }

        case '>': {
            int outputFile = open(substring(input, from + 1, to), O_CREAT | O_WRONLY | O_TRUNC, 0666);
            close(1);
            dup2(outputFile, 1);
            close(outputFile);
            return 1;
        }

        default: {
            return 0;
        }
    }
}

int cmd_name(int argc, char** tokens) {
    if (argc < 2) printf("%s\n", name);
    else strcpy(name, tokens[1]);
    return 0;
}

void printCmd(char* name, char* description) {
    printf("%10s - %s\n", name, description);
} 

int cmd_help() {
    printCmd("name", "Print or change shell name");
    printCmd("help", "Print short help");
    printCmd("status", "Print last command status");
    printCmd("exit", "Exit from shell");
    printCmd("print", "Print arguments");
    printCmd("echo", "Print arguments and newline");
    printCmd("pid", "Print PID");
    printCmd("ppid", "Print PPID");
    printCmd("dirchange", "Change directory");
    printCmd("dirwhere", "Print current working directory");
    printCmd("dirmake", "Make directory");
    printCmd("dirremove", "Remove directory");
    printCmd("dirlist", "List directory");
    printCmd("linkhard", "Create hard link");
    printCmd("linksoft", "Create symbolic/soft link");
    printCmd("linkread", "Print symbolic link target");
    printCmd("linklist", "Print hard links");
    printCmd("unlink", "Unlink file");
    printCmd("rename", "Rename file");
    printCmd("remove", "Remove file or directory");
    printCmd("cpcat", "Copy file");
    printCmd("pipes", "Create pipeline");
    return 0;
}

int cmd_status() {
    printf("%d\n", last_status);
    return 0;
}

int cmd_exit(int argc, char** tokens) {
    int status = atoi(tokens[1]);
    exit(status);
    return status;
}

int cmd_print(int argc, char** tokens) {
    for (int i = 1; i < argc; i++) {
        printf("%s", tokens[i]);
        if (i < argc - 1) printf(" ");
    }
    return 0;
}

int cmd_echo(int argc, char** tokens) {
    for (int i = 1; i < argc; i++) {
        printf("%s", tokens[i]);
        if (i < argc - 1) printf(" ");
        else printf("\n");
    }
    return 0;
}

int cmd_pid() {
    printf("%d\n", getpid());
    return 0;
}

int cmd_ppid() {
    printf("%d\n", getppid());
    return 0;
}

int cmd_dirchange(int argc, char** tokens) {
    char* path = argc > 1 ? tokens[1] : "/";
    errno = 0;
    if (chdir(path) < 0) {
        perror("dirchange");
        return errno;
    }
    return 0;
}

int cmd_dirwhere() {
    printf("%s\n", getCurrentPath());
    return 0;
}

int cmd_dirmake(int argc, char** tokens) {
    char* path = extendCurrentPath(tokens[1]);
    last_status = errno = 0;
    if (mkdir(path, S_IRWXU) < 0) {
        last_status = errno;
        perror("dirmake");
    }
    return last_status;
}

int cmd_dirremove(int argc, char** tokens) {
    char* path = extendCurrentPath(tokens[1]);
    errno = 0;
    if (rmdir(path) < 0) {
        perror("dirremove");
        return errno;
    }
    return 0;
}

int cmd_dirlist(int argc, char** tokens) {
    char* path = argc > 1 ? extendCurrentPath(tokens[1]) : getCurrentPath();

    DIR* dir = opendir(path);
    struct dirent *dp;

    while ((dp = readdir(dir)) != NULL) printf("%s  ", dp->d_name);

    closedir(dir);
    printf("\n");

    return 0;
}

int cmd_linkhard(int argc, char** tokens) {
    link(tokens[1], tokens[2]);
    return 0;
};

int cmd_linksoft(int argc, char** tokens) {
    symlink(tokens[1], tokens[2]);
    return 0;
};

int cmd_linkread(int argc, char** tokens) {
    char* path = extendCurrentPath(tokens[1]);

    char buffer[PATH_MAX];
    int len = readlink(path, buffer, sizeof(buffer));
    if (len != -1) {
        buffer[len] = '\0';
        printf("%s\n", buffer);
    }

    return 0;
};

int cmd_linklist(int argc, char** tokens) {
    char* path = extendCurrentPath(tokens[1]);
    errno = 0;
    struct stat sb;
    if (stat(path, &sb) == -1) {
        perror("linklist");
        return errno;
    }

    DIR* dir = opendir(getCurrentPath());
    struct dirent *dp;

    while ((dp = readdir(dir)) != NULL) {
        if (dp->d_ino == sb.st_ino) printf("%s  ", dp->d_name);
    }

    closedir(dir);
    printf("\n");

    return 0;
};

int cmd_unlink(int argc, char** tokens) {
    errno = 0;
    if (unlink(tokens[1]) != 0) {
        perror("unlink");
        return errno;
    };
    return 0;
};

int cmd_rename(int argc, char** tokens) {
    rename(tokens[1], tokens[2]);
    return 0;
};

int cmd_cpcat(int argc, char** tokens) {
    errno = 0;

    int source = argc < 2 ? 0 : open(tokens[1], O_RDONLY);
    int target = argc < 3 ? 1 : open(tokens[2], O_CREAT | O_WRONLY | O_TRUNC, 0666);

    if(errno) {
        perror("cpcat");
        return errno;
    }

    char buffer[1];
    while(read(source, buffer, 1)) write(target, buffer, 1);

    if(source != 0) close(source);
    if(target != 1) close(target);

    return 0;
};

int cmd_pipes(int argc, char** tokens) {
    int fdParent[2];
    int fdChild[2];

    for (int i = 1; i < argc; i++) {
        char** args = tokenizePipeArgs(tokens[i]);
        printf("%s\n", tokens[i]);
        if (i == 1) {
            pipe(fdChild);
            if (!fork()) {
                dup2(fdChild[1], 1);
                close(fdChild[0]);
                close(fdChild[1]);
                execvp(args[0], args);
            }
        } else if (i == argc - 1) {
            if (!fork()) {
                dup2(fdChild[0], 0);
                close(fdChild[0]);
                close(fdChild[1]);
                execvp(args[0], args);
            }

            close(fdChild[0]);
            close(fdChild[1]);
        } else {
            fdParent[0] = fdChild[0];
            fdParent[1] = fdChild[1];
            pipe(fdChild);
            if (!fork()) {
                dup2(fdParent[0], 0);
                dup2(fdChild[1], 1);
                close(fdParent[0]);
                close(fdParent[1]);
                close(fdChild[0]);
                close(fdChild[1]);
                execvp(args[0], args);
            }

            close(fdParent[0]);
            close(fdParent[1]);
        }

    }

    for (int i = 1; i < argc; i++) {
        wait(NULL);
    }

    return 0;
}
```