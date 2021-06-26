#include <stdio.h>

int main() {
    int a, b, c, povprecje;
    scanf("%d %d", &a, &b);
    povprecje = (a + b) / 2;

    do {
        scanf("%d", &c);
        if(c == 1) {

        }else if (c == -1) {

        }
        

        //temp
        printf("-%d\n", c);

    } while (c != 0);
    
    return 0;
}