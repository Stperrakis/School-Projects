#include "stdio.h"
#include "stdlib.h"
#include "math.h"

int main(int argc, char argv) {
    int i,n,j=1;
    float sum=1.5;
    printf("Give me please an integer: ");
    scanf("%d",&n);
    i=n;
    for(n=0; n<=i; n++) {
        sum+=j*(0,5*(pow((n+0,5),(n+1))));
        j=j*(-1);
    }

    printf("\n%f",sum);
}

