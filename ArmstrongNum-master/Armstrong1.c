#include <stdio.h>
#include <stdlib.h>
#include <stdio.h>
#include <stdlib.h>
int main(int argc, char** argv) {
    int sum,i,f=1,s=0,t=0;


    for(i=100; i<1000; i++) {
        if(t==10) {
            s++;
            t=0;
        }
        if(s==10) {
            f++;
            s=0;
        }
        if(pow(s,3)<i) {
            if(pow(t,3)<i) {


                if(pow(s,3)+pow(t,3)+pow(f,3)==i) {

                    printf("-%d-\n",i);
                }
            } else {
                t=-1;
                s++;
                i=f*100+s*10-1;
            }
        } else {
            f++;
            s=0;
            t=0;
            i=f*100;
        }
        t++;
    }
}
