#include <stdio.h>
#include <string.h>

int main() {
    int ukaz;
    char greeting[10];

    scanf("%d", &ukaz);
    for(int i = 0; i < 10; i++)
    {
        *strcat(getchar(), greeting);
    }
    
    printf("%s", greeting);
}