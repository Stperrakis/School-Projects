#include "stdio.h"
#include "stdlib.h"

int main(int argc, char argv) {
    int i,j=-1,k,z;
    float res,t;
    t = 1;
    while(j<0) {

        printf("Give me a valid number(positive)");
        scanf("%d",&j);
         }
    if (j==0) {
        printf("1");
        exit(1);
    } else {
        for (k=1; k<j+1; k++) {
            t=t*k;
            if(k==j) {
                z=t;
            }
        }
        printf("%f",pow(z,t));
    }
}
