#include <stdio.h>
#include <stdlib.h>
#define t 0.75
int main()
{
   float poso,ep;
   int con,ker,i;
   printf("%f\n",t);

   scanf("\n%f",&poso);

//2 1 0.5 0.2 0.10 0.05

        //2eura
    printf("To poso pou eisagate einai %G\n", poso);
    ep=poso-t ;
    printf("prepei na sas epistrafei %G \n", ep );
    con=(double)ep/2;
    printf("Ara pare %d 2 eyra\n",con);
    ep=ep-con*2 ;
    printf("To neo poso %G\n\n", ep);
    // 1eura
    if (ep>0)
    {
    printf("prepei na sas epistrafei %G \n", ep );
    con=(double)ep/1;
    printf("Ara pare %d 1 eyra\n",con);
    ep=ep-con*1 ;
    printf("To neo poso %G\n\n", ep);
    }
    ///0.5 eura
    if(ep>0)
    {
    printf("prepei na sas epistrafei %G \n", ep );
    con=(double)10*ep/5;
    printf("Ara pare %d 0.5 eyra\n",con);
    ep=ep-con*0.5 ;
    printf("To neo poso %G\n\n", ep);
    }
    // 20alepta
    if(ep>0)
    {
    printf("prepei na sas epistrafei %G \n", ep );
    con=(double)10*ep/2;
    printf("Ara pare %d 20alepta\n",con);
    ep=ep-con*0.2 ;
    printf("To neo poso %G\n\n", ep);
    }
    // 10lepta
    if (ep>0)
    {
     printf("prepei na sas epistrafei %G \n", ep );
    con=(double)ep*0.1;
    printf("Ara pare %d 10lepta\n",con);
    con=(double)10*ep/1;
    printf("To neo poso %G\n\n", ep);
    }
    //5lepta
     printf("prepei na sas epistrafei %G \n", ep );
    if (ep>0)
    {
        printf("Ara pare 1 5lepta\n");
        printf("To neo poso 0");
    }


    return 0;
}
