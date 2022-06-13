//
//  main.c
//  LAB10217534_set1_exer_1.c
//
//  Created by Stelios P on 2/3/13.
//  Copyright (c) 2013 Stelios Perrakis. All rights reserved.
//

#include <stdio.h>
#include <stdlib.h>

struct node
{
    int num;
    struct node *next;
};
int printeven(struct node *head,int b);
int main()
{
    int i=0,val,b=0,a=0;
    char t='c';

    printf("*---------------------------------------------------*\n");
    printf("|Welcome! \t\t\t\t\t\t\t\t\t\t\t|\n|This is a programm that has as an insert numbers of| \n|your choice and prints you the even of them\t\t|\n|Lets start\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t|\n");
    printf("*---------------------------------------------------*\n");
        struct node *new ;
    struct node *head ;
    head=NULL;
    for(;;)
    {
       if (i>1)
       {printf("~~If you want to be this node your last type e in case you want to continue type c~~ \n");
        scanf("%s", &t);
        if (t=='e')
           {
                    break ;
           }
       }
        i++;
        printf("Please type the number you want!!\n");
        scanf("%d", &val);
        new=malloc(sizeof(struct node));
        new->next=head ;
        head=new ;
        new->num=val ;

}

     a=printeven(head,b);
    /*if(head->num %2==1)
    {
        printf("\n%d\n", head->num);
        a=a+1;
    }*/
    printf("\nThe number of the even numbers in list are: %d\n",a);
    system("PAUSE");
    return 0;
}
    int printeven(struct node *head,int b)
{
        if(head->num %2==1)
        {
        printf("\n%d  %d\n", head->num, b);
           b++;

        }
   if (head->next!=NULL)
   {
       printeven(head->next, b);
   }


    printf("%d", b);
    return b ;
}
