// Andraz Mesaric-Sirec 63180202

#include <fcntl.h>
#include <stdio.h>
#include <errno.h>
#include <stdlib.h>
#include <dirent.h>

extern int errno;

int main(int argc, char *argv[]) {
    struct dirent *element;
    DIR *my_dir;

    my_dir = opendir(argc < 2 ? "." : argv[1]);
    if(my_dir == NULL) {
        write(1, "Failed to open dir!\n", 20);
        return 1;
    }

    while ((element = readdir(my_dir)) != NULL) printf("%s\n", element->d_name);
    
    closedir(my_dir);

    return 0;
}