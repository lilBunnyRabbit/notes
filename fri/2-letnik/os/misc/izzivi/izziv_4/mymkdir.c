// Andraz Mesaric-Sirec 63180202

#include <fcntl.h>
#include <stdio.h>
#include <errno.h>
#include <stdlib.h>

extern int errno;

int main(int argc, char *argv[]) {
    if(argc < 2) {
        write(1, "Usage: mymkdir <name>\n", 22);
        return 1;
    }

    if(mkdir(argv[1])) {
        perror("Failed to create folder!");
        exit(errno);
    }

    return 0;
}