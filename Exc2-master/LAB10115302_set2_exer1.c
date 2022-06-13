#include<stdio.h>
#include<string.h>
#include<stdlib.h>

#define MAX_NAME 50
#define MAX_JOB 30

#define FILENAME "employees.txt"

struct Employee{                   // creating a structure
       char fullname[MAX_NAME];
       char job[MAX_JOB];
       int salary;
};
 

///
//~ 
//~ 
//~ int atoi ( const char * str );
//~ 
//~ char * fgets ( char * str, int num, FILE * stream );
//~ 
//~ int fscanf ( FILE * stream, const char * format, ... );
//~ 
//~ int feof ( FILE * stream );
//
void swap(struct Employee* mt, int pos1 , int pos2);// function
void sortMyTable(struct Employee* mt, int len) ;//function1
int compareBySalary(struct Employee* emp1, struct Employee* emp2);//function2
int compareByName(struct Employee* emp1, struct Employee* emp2);//function3


int main()
{
       FILE* fp;
       char table[100], temp[100];
       struct Employee* myEmployees;
       int i,j,Nemployees=0,counter,pedio;
       
       fp=fopen ( FILENAME, "r");// opens the file
       if (fp==NULL)// Condition that the file doesn't open
       {         
             return -1;       
       }
       //reads the number of the Entries
       fgets(temp,100,fp);
       Nemployees=atoi(temp);//number of employees with convartion with atoi from char to integer
       
       myEmployees=(struct Employee*) malloc(Nemployees*sizeof(struct Employee));// dynamic memory allocation
       
       // Reads the entries fron the file
       for(j=0;j<Nemployees;j++)
       {
	       fgets(temp,100,fp);
	       counter=0;// counter that helps in the assignment
	       pedio=0;// Variable that helps to understand in which field to convert depending it
	       for (i=0;i <100; i++)
	       {
                  
                  if ((temp[i]==';')||(temp[i]=='\0'))// starting get chars from the file and copy it when the copy other has been finished
                  {
			table[counter]='\0';
                  	if (pedio==0)
                     		strcpy(myEmployees[j].fullname,table);
                  	if(pedio==1)
                     		strcpy(myEmployees[j].job,table);// conditions of the fields Fullname job sallary
                  	if (pedio==2)
                     		myEmployees[j].salary=atoi(table);// converting the char string to integer !!!FIELD OF THE SALLARY!!!
                     	counter=0;
                     	pedio++; // makes the variable pedio ++ to understant the next assigment
                   }
                   else
                   {
			table[counter]=temp[i];
			counter++;
		   }
		   
		   if (temp[i]=='\0')
                  {
			 // printf("tsa  %d %d \n ",j,i); debug
			  if (pedio!=3)//if pedio doesnt be 3 like beeing 2 or 4 it means that the is not in the form must be
			  {
				  puts("Kaki morfi arxeiou...");
			  	  return -1;
			  }
                  	break;
                  }
	       }
       }
       
       fclose(fp);
       
       sortMyTable(myEmployees,Nemployees);
       
       fp=fopen("output1.txt","w");// opens the output document
       
       fprintf(fp,"%d\n",Nemployees); // number of employees
       
       for(i=0;i<Nemployees;i++)
       {
		fprintf(fp,"%s;%s;%d\n",myEmployees[i].fullname, myEmployees[i].job, myEmployees[i].salary);      // puts in the file the sorted names
       }
       
       fclose(fp); // closes the file
       
system("pause");
}


/*
 * The function sorts the elements of a string table using the Bubble sort
 * algorithm
 */
void sortMyTable(struct Employee* mt, int len) {
    int sorted = 0, j = 0;
    // *temp;

    while(sorted != 1) {
        sorted = 1;
        for (j = 0; j < len - 1; j++) {
            
            if (compareByName(&(mt[j]),&(mt[j+1])) > 0) {// makes the comparison and swaps it 
                sorted = 0;
                swap(mt,j,j+1);
            }
        }
    }
}
/*
*  returns -1 if emp1<emp2 , +1 if emp1>emp2 , 0 if emp1==emp2
*/
int compareBySalary(struct Employee* emp1, struct Employee* emp2)// This function compares the Salaries
{
       
       if(emp1->salary > emp2->salary)
            return 1;
       else if(emp1->salary < emp2->salary)
            return -1;
       else 
            return 0;
}

/*
*  returns -1 if emp1<emp2 , +1 if emp1>emp2 , 0 if emp1==emp2
*/
int compareByName(struct Employee* emp1, struct Employee* emp2)//This function compares the names
{
       return strcmp(emp1->fullname,emp2->fullname);
}

void swap(struct Employee* mt, int pos1 , int pos2)// bubble sort that is known from the file
{
     /*Here is the swaping 1. copies in a stuct tmp wich helps something do not be lost*/
     struct Employee tmp;
//   temp = data[j + 1];
     strcpy(tmp.fullname, mt[pos2].fullname);//(*mt[pos2]).fullname
     strcpy(tmp.job, mt[pos2].job);//(*mt[pos2]).fullname
     tmp.salary= mt[pos2].salary;//(*mt[pos2]).fullname
     
//   data[j + 1] = data[j];
     strcpy(mt[pos2].fullname, mt[pos1].fullname);//(*mt[pos2]).fullname
     strcpy(mt[pos2].job, mt[pos1].job);//(*mt[pos2]).fullname
     mt[pos2].salary= mt[pos1].salary;//(*mt[pos2]).fullname
     
//   data[j] = temp;
     strcpy(mt[pos1].fullname, tmp.fullname);//(*mt[pos2]).fullname
     strcpy(mt[pos1].job, tmp.job);//(*mt[pos2]).fullname
     mt[pos1].salary= tmp.salary;//(*mt[pos2]).fullname
     
}
