#include <math.h>
#include <stdio.h>
#include <stdlib.h>
void drawPattern(long size ,long ident);
void drawPatternOffset(long size ,long ident, long offset); // Declare the functions
void printNchars(long n ,char c);
int main(int argc, const char * argv[])
{
    long a ;
    printf("Give an integer\n");// Requesting for an integer
    scanf("%d" , &a) ;
    drawPattern(a ,0);// Calls the drawPattern function
    //    scanf("%d" , &a) ;
printf("\n");
system ("PAUSE");
}
void drawPattern(long size ,long ident)// Starting drawPattern
{
    if(size==0)// Taking the zero as a exeption
    {
        printNchars(ident ,' ');//calling printNchars (typing spaces number of them is the ident)

        printNchars(1,'*');// Makes the print with the printNchars function printing 1 *
    }
    else //For other cations it goes in here
    {
        printNchars(ident ,' '); //calling printNchars
        drawPattern(size-1 ,0);

        printNchars(ident ,' '); //calling printNchars (typing spaces number of them is the ident)

        printf("\n");// Goes one line down
        printNchars(ident ,' ');// calling printNchars (typing spaces number of them is the ident)
        printNchars(pow(2,size) ,'*');// Makes the print with the printNchars function printing 2^size(size=a) *
        printf("\n");// Goes one line down
        printNchars(ident,' ');//calling printNchars and printing ident(number) of spaces
        drawPatternOffset(size-1, pow(2,size-1), ident);//calling drawPatternOffset
    }
}

void drawPatternOffset(long size ,long ident, long offset)
{
    if(size==0){

        printNchars(ident+offset,' ');
        printNchars(1,'*');
    }
    else
    {
        drawPatternOffset(size-1 ,ident, offset);


        printf("\n");
        printNchars(ident+offset,' ');
        printNchars(pow(2,size) ,'*');
        printf("\n");
        drawPatternOffset(size-1, pow(2,size-1), ident+offset);
    }
}

void printNchars(long n ,char c)
{
    int i;
    if (n>0)
    {
        for( i=1 ; i<=n;i++)
            printf("%c" ,c);
    }
}
