//
//  main.c
//  LAB111030_set1_exer_3
//
//  Created by Stelios P on 4/3/13.
//  Copyright (c) 2013 Stelios Perrakis. All rights reserved.
//

#include <stdio.h>
#include <stdlib.h>
#include <math.h>
struct node
{
    int num;
    struct node *next;
};
void pythagoras(struct node *head);


int main(int argc, const char * argv[])
{
    int val,i=0;
   // char t;
    printf("Hello, user this is a programm that has as input numbers of your choice and saying at you if the pythagorius theorem ");
    struct node *new ;
    struct node *head ;
    
    head=NULL;
    for (;;)
    {
        if (i>6)
        {//printf("~~If you want to be this node your last type e in case you want to continue type c~~ \n");
           // scanf("%c", &t);
            //if (t=='e'){
                break ;
            //}
        }
        i++;

        printf("Please type the number you want!!\n");
        scanf("%d", &val);
        new=malloc(sizeof(struct node));
        new->next=head ;
        head=new ;
        new->num=val ;
        
        
        
    }
    
    pythagoras(head);

    
}
void pythagoras (struct node *head)
{
  
    struct node *header,*head2 ;
    head2=head->next ;
    header=head2;
    header=header->next;
  printf("%d %d",head->num,head2->num);
   // if(((pow(head->num,2))==(pow(head2->num,2)+pow(header->num,2))))
       //{
        //   printf( "This trinity of numbers are applying pythagoras theorem:%d %d %d",head->num,head2->num,header->num);
       
      // }else {
           printf( "This trinity of numbers are not applying pythagoras theorem:%d %d %d",head->num,head2->num,header->num);
           
       //}
    pythagoras(head->next);
}
