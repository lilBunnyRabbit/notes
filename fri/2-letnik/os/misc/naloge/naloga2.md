```c
#include <fcntl.h>
#include <stdio.h>
#include <errno.h>
#include <stdlib.h>
#include <string.h>
#include <sys/utsname.h>
#include <stdlib.h>
#include <sys/resource.h>
#include <sys/time.h>
#include <sys/resource.h>
#include <dirent.h>

struct PIDDir {
    int pid;
    int ppid;
    char state[256];
    char name[256];
    int threads;
    int files;
};

struct PIDS {
    struct PIDDir* pidirs;
    int size;
};

int cmd_sys(int argc, char* argv[], int ext);
int cmd_me(int argc, char* argv[]);
int cmd_pids(int argc, char* argv[]);
int cmd_names(int argc, char* argv[]);
int cmd_ps(int argc, char* argv[], int ext);

int main(int argc, char* argv[]) {
    char* command = argv[1];

    if (!strcmp(command, "sys")) return cmd_sys(argc, argv, 0);
    if (!strcmp(command, "sysext")) return cmd_sys(argc, argv, 1);
    if (!strcmp(command, "me")) return cmd_me(argc, argv);
    if (!strcmp(command, "pids")) return cmd_pids(argc, argv);
    if (!strcmp(command, "names")) return cmd_names(argc, argv);
    if (!strcmp(command, "ps")) return cmd_ps(argc, argv, 0);
    if (!strcmp(command, "psext")) return cmd_ps(argc, argv, 1);
    return 0;
}

struct PIDS get_pid_dirs(char* path) {
    struct PIDS pids;
    pids.size = 0;

    {
        DIR* dir = opendir(path);
        struct dirent *dp;

        while ((dp = readdir(dir)) != NULL) {
            if (!strcmp(dp->d_name, ".") || !strcmp(dp->d_name, "..") || dp->d_type != DT_DIR) continue;
            pids.size += 1;
        }
        
        closedir(dir);
    }

    struct PIDDir* piddirs = malloc(sizeof(struct PIDDir) * pids.size);
    int index = 0;

    DIR* dir = opendir(path);
    struct dirent *dp;

    while ((dp = readdir(dir)) != NULL) {
        if (!strcmp(dp->d_name, ".") || !strcmp(dp->d_name, "..") || dp->d_type != DT_DIR) continue;
        piddirs[index].pid = atoi(dp->d_name);

        {
            char filePath[256];
            sprintf(filePath, "%s%d/comm", path, piddirs[index].pid);

            FILE* comm = fopen(filePath, "r");
            fscanf(comm, "%s", piddirs[index].name);

            fclose(comm);
        }
        
        {
            char filePath[256];
            sprintf(filePath, "%s%d/stat", path, piddirs[index].pid);

            char buffer[256];
            FILE* stat = fopen(filePath, "r");
            fscanf(
                stat, 
                "%*d%*s%s%d%*d%*d%*d%*d%*u%*u%*u%*u%*u%*d%*d%*d%*d%*d%*d%d", 
                piddirs[index].state, 
                &piddirs[index].ppid,
                &piddirs[index].threads
            );

            fclose(stat);
        }

        {
            char dirPath[256];
            sprintf(dirPath, "%s%d/fd", path, piddirs[index].pid);
            DIR* fddir = opendir(dirPath);
            struct dirent *fddp;

            int files = 0;
            while ((fddp = readdir(fddir)) != NULL) {
                if (!strcmp(fddp->d_name, ".") || !strcmp(fddp->d_name, "..") || fddp->d_type == DT_DIR) continue;
                files++;
            }

            piddirs[index].files = files;

            closedir(fddir);
        }

        index++;
    }

    closedir(dir);

    pids.pidirs = piddirs;
    return pids;
}

void swap(struct PIDDir* a, int i, int j){
    struct PIDDir tmp = a[i];
    a[i] = a[j];
    a[j] = tmp;
}

void sortPids(struct PIDDir* a, int n, int type){
    for(int i = 0; i < n; i++) {
        for(int j = n - 1; j > i; j--) {
            if (type == 1) {
                if(a[j].pid < a[j - 1].pid) {
                    swap(a, j, j-1);
                }
            } else if (type == 2) {
                int compare = strcasecmp(a[j].name, a[j - 1].name);
                if(compare < 0 || (compare == 0 && a[j].pid < a[j - 1].pid)) {
                    swap(a, j, j-1);
                }
            }
        }
    }

}

int cmd_sys(int argc, char* argv[], int ext) {
    char* path = argc > 2 ? argv[2] : "/proc/";
    if (path[strlen(path) - 1] != '/') strcat(path, "/");

    {
        char* filePath = strdup(path);
        strcat(filePath, "version");

        char buffer[256];
        FILE* version = fopen(filePath, "r");

        fscanf(version, "%*s%*s%s", buffer);
        printf("Linux: %s\n", buffer);

        fscanf(version, "%*s%*s%*s%s", buffer);
        printf("gcc: %s\n", buffer);

        free(filePath);
        fclose(version);
    }

    if (!ext) return 0;

    {
        char* filePath = strdup(path);
        strcat(filePath, "swaps");

        char buffer[256];
        FILE* swaps = fopen(filePath, "r");

        fgets(buffer, sizeof(buffer) / sizeof(buffer[0]), swaps);

        fscanf(swaps, "%s", buffer);
        printf("Swap: %s\n", buffer);

        free(filePath);
        fclose(swaps);
    }

    int modulesCounter = 0;

    {
        char* filePath = strdup(path);
        strcat(filePath, "modules");

        char buffer[256];
        FILE* modules = fopen(filePath, "r");

        for (char c = getc(modules); c != EOF; c = getc(modules)) {
            if (c == '\n') modulesCounter += 1;
        }
        
        printf("Modules: %d\n", modulesCounter);

        free(filePath);
        fclose(modules);
    }

    return modulesCounter;
}

int cmd_me(int argc, char* argv[]) {
    pid_t pid = getpid();

    {
        printf("Uid: %d\n", getuid());
        printf("EUid: %d\n", geteuid());
        printf("Gid: %d\n", getgid());
        printf("EGid: %d\n", getegid());
        
        char cwd[256];
        getcwd(cwd, 256);
        printf("Cwd: %s\n", cwd);

        printf("Priority: %d\n", getpriority(PRIO_PROCESS, pid));
    }

    {
        char processPath[256];
        sprintf(processPath, "/proc/%d/", pid);

        printf("Process proc path: %s\n", processPath);
        printf("Process proc access: %s\n", access(processPath, F_OK) ? "no" : "yes");
    }

    {
        struct utsname buffer;
        uname(&buffer);

        printf("OS name: %s\n", buffer.sysname);
        printf("OS release: %s\n", buffer.release);
        printf("OS version: %s\n", buffer.version);
        printf("Machine: %s\n", buffer.machine);
        printf("Node name: %s\n", buffer.nodename);
    }

    {
        struct timezone tz;
        gettimeofday(NULL, &tz);

        printf("Timezone: %d\n", tz.tz_minuteswest);
    }

    {
        struct rlimit lim;
        getrlimit(RLIMIT_CPU, &lim);

        printf("CPU limit: %ld\n", lim.rlim_max);
    }
    return 0;
}

int cmd_pids(int argc, char* argv[]) {
    char* path = argc > 2 ? argv[2] : "/proc/";
    if (path[strlen(path) - 1] != '/') strcat(path, "/");

    struct PIDS pids = get_pid_dirs(path);

    sortPids(pids.pidirs, pids.size, 1);
    for (int i = 0; i < pids.size; i++) {
        printf("%d\n", pids.pidirs[i].pid);
    }
    return 0;
}

int cmd_names(int argc, char* argv[]) {
    char* path = argc > 2 ? argv[2] : "/proc/";
    if (path[strlen(path) - 1] != '/') strcat(path, "/");

    struct PIDS pids = get_pid_dirs(path);

    sortPids(pids.pidirs, pids.size, 2);
    for (int i = 0; i < pids.size; i++) {
        printf("%d %s\n", pids.pidirs[i].pid, pids.pidirs[i].name);
    }
    return 0;
}

int cmd_ps(int argc, char* argv[], int ext) {
    int parent = argc > 3 ? atoi(argv[3]) : -1; 

    char* path = argc > 2 ? argv[2] : "/proc/";
    if (path[strlen(path) - 1] != '/') strcat(path, "/");

    struct PIDS pids = get_pid_dirs(path);

    sortPids(pids.pidirs, pids.size, 1);

    if (ext) {
        printf("%5s %5s %6s %6s %6s %s\n", "PID", "PPID", "STANJE", "#NITI", "#DAT.", "IME");
        for (int i = 0; i < pids.size; i++) {
            if (parent != -1) {
                if (pids.pidirs[i].ppid != parent && pids.pidirs[i].pid != parent) continue;
            }
            printf("%5d %5d %6s %6d %6d %s\n", pids.pidirs[i].pid, pids.pidirs[i].ppid, pids.pidirs[i].state, pids.pidirs[i].threads, pids.pidirs[i].files, pids.pidirs[i].name);
        }
    } else {
        printf("%5s %5s %6s %s\n", "PID", "PPID", "STANJE", "IME");
        for (int i = 0; i < pids.size; i++) {
            if (parent != -1) {
                if (pids.pidirs[i].ppid != parent && pids.pidirs[i].pid != parent) continue;
            }
            printf("%5d %5d %6s %s\n", pids.pidirs[i].pid, pids.pidirs[i].ppid, pids.pidirs[i].state, pids.pidirs[i].name);
        }
    }

    return 0;
}
```