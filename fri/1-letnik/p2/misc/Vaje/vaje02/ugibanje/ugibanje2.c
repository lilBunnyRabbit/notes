#include <stdio.h>

int main() {
    int spMeja, zgMeja;
    scanf("%d %d", &spMeja, &zgMeja);

    int odgovor;

    do {
        int poskus = (spMeja + zgMeja) / 2;
        scanf("%d", &odgovor);

        if(odgovor == 1) {
            spMeja = poskus + 1;

        } else if(odgovor == -1) {
            zgMeja = poskus + 1;
        }


    } while (odgovor != 0 && spMeja <= zgMeja);

    if(spMeja == zgMeja) {
        printf("%d", spMeja);
    }else if(spMeja < zgMeja) {
        printf("%d", zgMeja);
    }else {
        printf("%d %d",spMeja, zgMeja);
    }

    
    
    return 0;
}