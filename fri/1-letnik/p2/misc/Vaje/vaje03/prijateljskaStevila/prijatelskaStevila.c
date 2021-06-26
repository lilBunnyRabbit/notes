#include <stdio.h>

int sestevekDeliteljev(int stevilo) {
    int sestevek = 0;
    for(int i = 1; i < stevilo; i++) {   
        if(stevilo % i == 0) {
            sestevek = sestevek + i;
        }
    }
    
    return sestevek;
}

int main() {
    int stevilo;

    scanf("%d", &stevilo);

    int kandidat = sestevekDeliteljev(stevilo);

    if(sestevekDeliteljev(kandidat) == stevilo) {
        printf("%d\n", kandidat);
    }else {
        printf("%s\n", "NIMA");
    }
    
    return 0;
}
