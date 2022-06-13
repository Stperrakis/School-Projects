 

#include <stdio.h>
#include <stdlib.h>
int main()
{
    int l=0, m=0, g=0 , s=0,e, *buffer,*buffer1,*buffer2,*buffer3,n,h,i,j,k;
    do
    {
       printf ("Dwse arithmo grammwn dexete mono thetikous: \t");//prints a message
       do
       {
           scanf("%d", &g);// scans for the size of the matrix
       }while (g<=0);//Negative numbers and Zero cannot be accepted
       printf ("Dwste arithmo sthlwn dexete mono thetikous: \t");//prints a message
       do
       {
              scanf("%d", &s);// scans for the size of the matrix
       }while (s<=0);//Negative numbers and Zero cannot be accepted
       buffer1= (int*) malloc (sizeof(int)*(s*g));//malloc for the first matrix
       for (n=0; n<(s*g); n++)
       {
           buffer1[n]=0;// Initializes the dynamically allocating memory
           scanf("%d", &h);//Scaning for the info of the matrix
           buffer1[n]=h;//replacement
       }
       
       printf("Twra gia ton deutero pinaka\n");//prints a message
       printf ("Dwse arithmo grammwn dexete mono thetikous: \t");//prints a message
       do
       {
              scanf("%d", &l);// scans for the size of the matrix
       }while (l<=0);//Negative numbers and Zero cannot be accepted
        
        printf ("Dwste arithmo sthlwn dexete mono thetikous: \t");//prints a message
        do
        {
               scanf("%d", &m);// scans for the size of the matrix
        }while (m<=0);//Negative numbers and Zero cannot be accepted
        buffer2= (int*) malloc (sizeof(int)*(m*l));//malloc for the second matrix
        
        for (n=0; n<(m*l); n++)
        {
            buffer2[n]=0;//Initializes the dynamically allocating memory
            scanf("%d", &h);//Scaning for the info of the matrix
            buffer2[n]=h;//replacement
        }
        /////////////////////////////////////
        /*for (i=0; i<(g*s);i++)
                {
                    if (i%s==0)
                   {   printf("\n");
                   }
                   printf ("%d " ,buffer1[i]);
               }
                printf("\n");
       for (i=0; i<(l*m);i++)
                {
                    if (i%m==0)
                   {   printf("\n");
                   }
                   printf ("%d " ,buffer2[i]);
               }
       printf("\n");*/
       ///////////////////////////////////////
        printf ("\n1.Prosthesh\n2.polaplasiasmo \n3.Exit\n");
        scanf ("%d", &e);
        
        if ((e==1)&&((s==m)&&(l==g)))//Situations of the Sum
        {      
               buffer= (int*) malloc (sizeof(int)*(m*l));//malloc for the result matrix
               //puts("t");
               for (n=0; n<(s*g); n++)
               {
                   buffer[n]=buffer1[n]+buffer2[n];//do the calculation
                  // printf(" \t %d  %d",n, buffer1[n]);
               }
               for (i=0; i<(s*g);i++)// prints the matrix
               {
                   if (i%s==0)
                   {printf("\n");
                   }
                   printf ("%d " ,buffer[i]);
               } 
        }
        if ((e==2)&& (l==s))//situation for the Multiplication
        {
                buffer=(int*) malloc(sizeof(int)*m*g);//mallocs it(allocates dynamik memory)
                     
                for(i=0;i<g;i++)
                {
                    for(j=0;j<m;j++)
                    {
                        buffer[i*g+j]=0;
                        for(k=0;k<l;k++)
                        {
                             buffer[i*g+j]+=buffer1[i*g+k]*buffer2[k*m+j];// The Multiplication
                             //printf(" \t %d  %d   %d \t i=%d j=%d k=%d", buffer[i*g+j], buffer1[i*g+k],buffer2[k*m+j],i,j,k);
                        }
                    }
                }
                for (i=0; i<(g*m);i++)
                {
                    if (i%s==0)
                   {   printf("\n");
                   }
                   printf ("%d " ,buffer[i]);// printing the matrix
               }
                printf("\n");
        }
        free(buffer);//unchain the memory
        free(buffer);//unchain the memory
        free(buffer2);//unchain the memory
    }while (e!=3);
 
return 0 ;
}

