#include <stdio.h>
#include <stdlib.h>

int main(int argc, char** argv) {
    int max1=1,max2=0,k=-1,j;
    while(k<=2) {
        printf("Give me please the number of inserts that you want to : ");
        scanf("%d",&k);                     //checking for positive numbers
    }
    while(k!=0) {
        scanf("%d",&j);//scans the number
        if(j>max1||j>max2) { // if its bigger from max1 or max2 then
            if(max1-max2<0)   // checks which is bigger and replace it
                max1=j;
            else {
                max2=j;
            }
        }
        k--;
    }
    printf("---- %d, %d ---- ",max1,max2);
}
