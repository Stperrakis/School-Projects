#include <stdio.h>
#include <stdlib.h>
#include <string.h>
struct numb    // I made here a struct for the delays of the numbers
{
    int number ;
    int delay;
};
struct draw   //The main Struct of the program here we have everything about a draw !
{
    int id;
    int day,month,year;
    int n1,n2,n3,n4,n5;
    int joker;
    int active;
};
char *TransferFile(char *file)   //In order to make the program run "faster" i managed to transfer all the file in to string so we don't have to deal with the HD to much!
{
    fseek(file, 0, SEEK_END);
    long fsize = ftell(file);
    fseek(file, 0, SEEK_SET);

    char *string = malloc(fsize + 1);
    fread(string, fsize, 1, file);
    fclose(file); //close the file is no more needed :)
    return string;
}
struct draw *blockManager(char *string,struct draw *myDraw,int *size)   //Here is my Parser it takes the string that the file was transfered before and mines all the useful
{
    //info we need moreover this function creates enough space for all the inserts :)
    int i=0,s=0,j,x,sign;
    while(string[i]!='\0')
    {
        if(string[i]=='\n')
        {
            *size=*size+1;
        }

        i++;
    }
    myDraw= malloc(*size*sizeof(struct draw));
    if(myDraw==NULL)
    {
        printf("Memory Allocation Error");
        free(myDraw);
        exit(1);
    }
    else
    {
        i=0;
        while(s<*size)
        {
            for(j=1; j<11; j++)
            {
                x=0;
                sign=1;
                while(string[i]!=';'&&string[i]!='/'&&string[i]!='\n')
                {

                    if(string[i]=='-')
                    {
                        sign=-1;
                    }
                    else if (string[i]>='0'&&string[i]<='9')
                    {
                        x+=string[i]-48;
                    }
                    if(string[i+1]!=';'&&string[i+1]!='/'&&string[i+1]!='\n')
                    {
                        x=x*10;
                    }
                    i++;
                }
                i++;
                x=x*sign;
                switch(j)
                {
                case 1 :
                    myDraw[s].id=x;
                    break;

                case 2:
                    myDraw[s].day=x;
                    break;

                case 3:
                    myDraw[s].month=x;
                    break;

                case 4:
                    myDraw[s].year=x;
                    break;

                case 5:
                    myDraw[s].n1=x;
                    break;

                case 6:
                    myDraw[s].n2=x;
                    break;

                case 7:
                    myDraw[s].n3=x;
                    break;

                case 8:
                    myDraw[s].n4=x;
                    break;
                case 9:
                    myDraw[s].n5=x;
                    break;

                case 10:
                    myDraw[s].joker=x;
                    break;
                }
            }

            s++;

            myDraw[s].active=1;//flag!
        }

    }
    free(string);//free the string no more needed :)
    return myDraw;

}
int searchByField(int d,int m, int y,struct draw *myDraw,int size,int field)   //here we have Search by each field we want i took the possible maximum parameters!
{
    int i=0,total=0 ;
    if(field==1)
    {
        while(i<=size)
        {
            if(d==myDraw[i].id)   //serial search by id
            {
                print(i,myDraw);
                return i;
            }
            i++;
        }
    }
    else if (field==2)
    {
        while(i<=size)
        {
            if(d==myDraw[i].day&&m==myDraw[i].month&&y==myDraw[i].year) //search by year
                print(i,myDraw);
            total++;


        }
        i++;
    }

    else if (field==3)
    {
        while(i<=size)
        {
            if(d==myDraw[i].n1||d==myDraw[i].n2||d==myDraw[i].n3||d==myDraw[i].n4||d==myDraw[i].n5)   //number
            {
                print(i,myDraw);
                total++;
            }
            i++;
        }
    }
    else if (field==4)
    {
        while(i<=size)
        {
            if(d==myDraw[i].joker)   //and the Joker search
            {
                print(i,myDraw);
                total++;
            }
            i++;
        }
    }

}
void computation(int i,struct draw * myDraw)   //This function has as parameter the identical number for the draw we want, we can compute the draw and make it how we want to !
{
    int choise,s;
    printf("\nWhat you want to chage>> \n1.id\n2.date\n3.Numbers\n ");
    scanf("%d",&choise);
    switch(choise)
    {
    case 1:
    {
        printf("\nInsert:");
        scanf("%d",&s);
        myDraw[i].id=s;
        break;
    }

    case 2:
    {
        printf("\nInsert day:");
        scanf("%d",&s);
        myDraw[i].day=s;

        printf("\nInsert month:");
        scanf("%d",&s);
        myDraw[i].month=s;

        printf("\nInsert year:");
        scanf("%d",&s);
        myDraw[i].year=s;
        break;
    }
    case 3:
    {
        printf("Give choise>1.n1\n2.n2\n3.n3\n4.n4\n5.n5\n6.Joker\n");
        scanf("%d",&s);
        switch(s)
        {
        case 1:
        {
            printf("\nGive me the number: ");
            scanf("%d",&s);
            myDraw[i].n1=s;
            break;
        }
        case 2:
        {
            printf("\nGive me the number: ");
            scanf("%d",&s);
            myDraw[i].n2=s;
            break;
        }
        case 3:
        {
            printf("\nGive me the number: ");
            scanf("%d",&s);
            myDraw[i].n3=s;
            break;
        }
        case 4:
        {
            printf("\nGive me the number: ");
            scanf("%d",&s);
            myDraw[i].n4=s;
            break;
        }
        case 5:
        {
            printf("\nGive me the number: ");
            scanf("%d",&s);
            myDraw[i].n5=s;
            break;
        }
        case 6:
        {
            printf("\nGive me the number: ");
            scanf("%d",&s);
            myDraw[i].joker=s;
            break;
        }
        break;
        }
    }

    }
    print(i,myDraw);
}
void print(int i, struct draw *myDraw)  //i Managed to do this Function because printing was real pain in the neck !
{
    if(myDraw[i].active==1)
    {
        printf("=>id:%d date:%d/%d/%d n1:%d n2:%d n3:%d n4:%d n5:%d Joker:%d\n",myDraw[i].id,myDraw[i].day,myDraw[i].month,myDraw[i].year,myDraw[i].n1,myDraw[i].n2,myDraw[i].n3,myDraw[i].n4,myDraw[i].n5,myDraw[i].joker);
    }
}
void del(struct draw *myDraw,int target,int size)   //I'am not really happy about doing delete with flagging if i had more time i definitely do it as doubly linked list
{
    //i think its possibly better about managing blocks and links!
    int i=0;
    while(i<size)
    {
        if(myDraw[i].id==target)
        {
            myDraw[i].active=0;
        }
        i++;
    }
}
void freq(int i,struct draw *myDraw,int Choise,int size)   //this function returns our frequency, as parameter it has the choice of the user to determine if he/she wants for joker or a number
{
    int j=0;
    float freqq,s=0,size2;
    size2=size;

    if(Choise==10)
    {
        while(j<size)
        {
            if((myDraw[j].n1==i||myDraw[j].n2==i||myDraw[j].n3==i||myDraw[j].n4==i||myDraw[j].n5==i)&&myDraw[j].active==1)
            {
                s++;
            }
            j++;
        }
        freqq=(s/size2);
        printf("\nThe frequency of the number: %d is: %f -> %f %c total\n",i,(s/size2),(s/size2)*100,37);

    }
    if(Choise==11)
    {
        while(j<size)
        {
            if(myDraw[j].joker==i&&myDraw[j].active==1)
            {
                s++;
            }
            j++;
        }
        printf("\nThe frequency of the Joker number: %d is: %f -> %f %c total\n",i,(s/size2),(s/size2)*100,37);
    }

}
struct numb * delay(int Choise,struct draw *myDraw,int size)   //Here we have our delay function as i said i am returning here an Array that is Struct and assorted by ascent
{


    struct numb *MyArray,temp;
    int total,i;
    if(Choise==1)
    {
        total=21;
    }
    else
    {
        total=46;
    }
    if(Choise==1)
    {

        int s,start,flag;
        MyArray=calloc(21,sizeof(struct numb));
        for   (i=0; i<21; i++)
        {
            MyArray[i].number=i;
        }
        i=0;
        while(i<21)
        {
            flag=0;
            s=size;
            start=0;
            while(s>=0)
            {
                if(myDraw[s].joker==i &&flag==0&&myDraw[s].active==1)
                {
                    flag=1;
                    start=s;
                }

                else if (flag==1&&myDraw[s].joker==i&&myDraw[s].active==1)
                {
                    flag=2;
                    break;
                }
                s--;
            }
            if(flag==2)
            {
                MyArray[i].delay=start-s;
            }
            else
            {
                MyArray[i].delay=0;
            }
            i++;
        }


    }
    else
    {
        int s,start,flag;
        MyArray=calloc(total,sizeof(struct numb));
        for   (i=0; i<46; i++)
        {
            MyArray[i].number=i;
        }
        i=0;
        while(i<total)
        {
            flag=0;
            s=size;
            while(s>=0)
            {
                if((myDraw[s].n1==i||myDraw[s].n2==i||myDraw[s].n3==i||myDraw[s].n4==i||myDraw[s].n5==i)&&flag==0&&myDraw[s].active==1)
                {
                    flag=1;
                    start=s;
                }

                else if (flag==1&&(myDraw[s].n1==i||myDraw[s].n2==i||myDraw[s].n3==i||myDraw[s].n4==i||myDraw[s].n5==i)&&myDraw[s].active==1)
                {
                    flag=2;
                    break;
                }
                s--;
            }
            if(flag==2)
            {
                MyArray[i].delay=start-s;
            }
            else
            {
                MyArray[i].delay=0;
            }
            i++;
        }


    }
    int max,j;
    for(i=total-1; i>0; i--)
    {
        max=0;
        for(j=1; j<=i; j++)
        {

            if(MyArray[j].delay>MyArray[max].delay)
            {
                max=j;
            }
        }
        temp=MyArray[i];
        MyArray[i]=MyArray[max];
        MyArray[max]=temp;
    }


    for(i=0; i<total; i++)
    {
        printf("%d->%d\n",MyArray[i].number,MyArray[i].delay);
    }
    return MyArray;
}
int insertion (struct draw **myDraw,int size)   //Creating a new block for the new member
{

    size=size+1;
    struct draw *temp=(struct draw*)realloc(*myDraw,(size+1)*sizeof(struct draw));
    if(temp==NULL)
    {
        printf("\nCan not allocate more!\n");
        return size-1;
    }
    else
    {
        *myDraw=temp;
        return size;
    }

}
void save(struct draw *myDraw,int size)   //writing on a new file
{
    FILE* fp=NULL;
    int i;
    fp=fopen("newJoker.csv","w");
    for(i=0; i<=size; i++)
    {
        if(myDraw[i].active==1)//checking if it is deleted!
            fprintf(fp,"%d;%d/%d/%d;%d;%d;%d;%d;%d;%d;\n",myDraw[i].id,myDraw[i].day,myDraw[i].month,myDraw[i].year,myDraw[i].n1,myDraw[i].n2,myDraw[i].n3,myDraw[i].n4,myDraw[i].n5,myDraw[i].joker);
    }
    fclose(fp);
}
void insertblock(struct draw *myDraw,int size)   //initializing the new member
{
    int i ;
    i=-1;
    while(i<0||i>31)
    {
        printf("\nGive me day: ");
        scanf("%d",&i);
        myDraw[size].day=i;
    }

    myDraw[size].id=myDraw[size-1].id+1;
    myDraw[size].year=myDraw[size-1].year;
    i=-1;
    while(i<0||i>12)
    {
        printf("\nGive me month: ");
        scanf("%d",&i);
        myDraw[size].month=i;
    }
    i=-1;
    while(i<0||i>46)
    {
        printf("\nGive me n1: ");
        scanf("%d",&i);
        myDraw[size].n1=i;
    }
    i=-1;
    while(i<0||i>46)
    {
        printf("\nGive me n2: ");
        scanf("%d",&i);
        myDraw[size].n2=i;
    }
    i=-1;
    while(i<0||i>46)
    {
        printf("\nGive me n3: ");
        scanf("%d",&i);
        myDraw[size].n3=i;
    }
    i=-1;
    while(i<0||i>46)
    {
        printf("\nGive me n4: ");
        scanf("%d",&i);
        myDraw[size].n4=i;
    }
    i=-1;
    while(i<0||i>46)
    {
        printf("\nGive me n5: ");
        scanf("%d",&i);
        myDraw[size].n5=i;
    }
    i=-1;
    while(i<0||i>21)
    {
        printf("\nGive me joker: ");
        scanf("%d",&i);
        myDraw[size].joker=i;
    }
    print(size,myDraw);

}
int main()   //our main
{

    struct draw *myDraw=NULL;
    struct numb *delayAr=NULL;

    FILE* file=NULL;
    file = fopen("joker.csv","r");

    char *string;
    int   size=0,Choice,i=0,d,y,m;

    while(Choice!=15)
    {
        printf("\n*========================================*\n");//MENU it could be on function for better , i wish i could have more time !
        printf("1.Load file\n2.Save file\n3.Insert draw\n4.Search by id\n5.Search by date\n6.Search by number\n7.Search by joker\n8.Compute a draw\n9.Delete a draw\n10.Frequency of number\n11.Joker frequency\n12.Delay \n13.Suggestion\n14.Exit \n");
        printf("\n*========================================*\n");
        printf("Select your Choice: ");
        scanf("%d",&Choice);
        printf("\n");
        switch(Choice)
        {
        case 1 :
            if(myDraw==NULL)   //checking this is really important because if you load the file and then going to load it again it stops because myDraw has already formed
            {

                if (file==NULL)
                {
                    printf("Check your File");
                    exit(-1);
                }
                else
                {

                    printf("Opening file completed!\n");
                }
                string=TransferFile(file);//file to string
                myDraw=blockManager(string,myDraw,&size);//making the array of structs
            }
            break;
        case 2 :
            if(myDraw!=NULL)
            {
                save(myDraw,size);//saving to a new file
                printf("Saving completed!\n");
            }
            break;
        case 3 :
            if(myDraw!=NULL)
            {

                size=insertion(&myDraw,size-1);//new block
                insertblock(myDraw,size);//initialize the block
                printf("New block successfully created!\n");
            }
            else
            {
                printf("\nYou have to load File First\n");//error
            }
            break;
        case 4 :
            if(myDraw==NULL) break;
            printf("\nGive me the target:");
            scanf("%d",&i);
            printf("\n");
            searchByField(i,0,0,myDraw,size,1);//maximum parameters for all the possible Searches
            break;
        case 5 :
            if(myDraw==NULL) break;
            scanf("%d %d %d",&d,&m,&y);
            searchByField(d,m,y,myDraw,size,2);
            break;
        case 6 :
            if(myDraw==NULL) break;
            scanf("%d",&i);
            searchByField(i,0,0,myDraw,size,3);
            break;
        case 7 :
            if(myDraw==NULL) break;
            scanf("%d",&i);
            searchByField(i,0,0,myDraw,size,4);
            break;
        case 8 :
            if(myDraw==NULL) break;//Always checking if our array have info!
            printf("\nGive me the id number of draw you want to compute:\n");
            scanf("%d",&i);
            i=searchByField(i,0,0,myDraw,size,1);
            computation(i,myDraw);
            break;
        case 9 :
            if(myDraw==NULL) break;
            printf("Give me the id's 1(number) that you want to Delete: \n");
            scanf("%d",&i);
            del(myDraw,i,size);
            break;
        case 10 :
            if(myDraw==NULL) break;
            printf("\nGive me the number : \n");
            scanf("%d",&i);
            freq(i,myDraw,Choice,size);
            break;
        case 11 :
            if(myDraw==NULL) break;
            printf("\nGive me the number : \n");
            scanf("%d",&i);
            freq(i,myDraw,Choice,size);
            break;
        case 12 :
            if(myDraw==NULL) break;
            do
            {
                printf("\nDelay for 1.Joker 2.Number\n"); //checking for the right insertion!
                scanf("%d",&d);
            }
            while(d!=1&&d!=2);
            if(d==1)
            {
                delayAr=delay(1,myDraw,size);
            }
            else
            {
                delayAr=delay(2,myDraw,size);
            }
            break;

        case 13:
            //Did not manage do it because the time that i had was struggling me
            break;

        case 14 :
            free(myDraw);
            free(delayAr);
            return 0; //exit


        }

    }

}
