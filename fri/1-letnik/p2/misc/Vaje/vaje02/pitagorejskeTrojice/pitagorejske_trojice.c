#include <stdio.h>
#include <stdbool.h>
#include <math.h>

// gcc pitagorejske_trojice.c -o pitagorejske_trojice -std=c99 -Wall -pedantic -lm
// export name=pitagorejske
// echo $name
// make
// make test

int main() {
    int spMeja, zgMeja;

    scanf("%d %d", &spMeja, &zgMeja);

    int stevec = 0;

    for(int c = spMeja; c <= zgMeja; c++) {

        for(int a = 1; a < c; a++) {
            int b2 = c * c - a * a;
            int b = round(sqrt(b2));
            
            if(b * b == b2) {
                stevec++;
                break;

            }
            
        }
        
    }

    printf("%d\n", stevec);t

   
    return 0;
}
