// Andraz Mesaric-Sirec 63180202

#include <fcntl.h>
#include <stdio.h>
#include <errno.h>
#include <stdlib.h>

extern int errno;

struct File {
    int file;
    char* name;
};

void check_file(struct File file);
void close_file(struct File file);

int main(int argc, char *argv[]) {
    struct File input_file = { .name = argc > 1 ? argv[1] : "stdin", .file = 0 };
    struct File output_file = { .name = argc > 2 ? argv[2] : "stdout", .file = 1 };

    if (argc > 1 && input_file.name[0] != '-') input_file.file = open(input_file.name, O_RDONLY);
    check_file(input_file);

    if (argc > 2) output_file.file = open(output_file.name, O_WRONLY | O_CREAT | O_TRUNC, 0644);
    check_file(output_file);

    char* buffer = (char *) calloc(1, sizeof(char));
    while (read(input_file.file, buffer, 1)) write(output_file.file, buffer, 1);

    close_file(input_file);
    close_file(output_file);
    
    return 0;
}

void check_file(struct File file) {
    if (file.file < 0) {
        perror("Failed to open file");
        exit(errno);
    }
}

void close_file(struct File file) {
    if (close(file.file) < 0) {
        perror("Failed to close file");
        exit(errno);
    }
}