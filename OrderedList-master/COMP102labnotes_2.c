// ----------------------------------------
// PLH102: 28/2/2013 - 1st LAB
//
// WRITE THE SOURCE CODE THAT IS MISSING 
// (find comments "TO DO")
// 
// ----------------------------------------

#include <stdio.h>
#include <stdlib.h>

struct list{
	int value;
	struct list *next;
};

struct list **searchNextNodeList(int v, struct list **ptr) { 
	if (*ptr == NULL)
		return ptr; 
	return ((*ptr)->value >= v) ? ptr : searchNextNodeList(v, &((*ptr)->next) );    
}

void insertNodeList(int v, struct list **l) { 
	struct list *node;
	struct list **node2 = searchNextNodeList(v, l);
	node = (struct list *)malloc(sizeof(struct list));
	node->value = v;
	node->next = *node2;
	*node2 = node;
}

//----------------
// PRINT
//----------------
void printList(struct list *l){
	
	while(l != NULL){
		printf("%d ", l->value);
		l = l->next;
    }             	
}

// --------------------------
// FREE
// --------------------------
void freeList(struct list *node){
	struct list *tmp = node;
    
    while(tmp != NULL){
		node = node->next;
		free(tmp);
		tmp = node;
    }
}


// -------------------------
// TO DO: SWAP n1 and n2
// -------------------------
void swap(struct list *n1, struct list *n2, struct list *head){

}

int main(){
	char buf[20];
	struct list *head;

	FILE *fp;
	int value, node1, node2, i;
	struct list *n1, *n2;

	// the list is initially empty
	head = NULL;

// ------------------------------------------------
// TO DO: read from file and construct ordered list
// ------------------------------------------------
printf("give me the name of the file \n \n");
scanf("%s",buf);
fp=fopen(buf,"r");
if (fp==NULL)
{
           return -1;
           printf("the file does not exist\n\n");
}
while(fscanf(fp,"%d",&value)!=EOF){
insertNodeList(value, &head);
system("Pause");
}
// ------------------------------------------------
// TO DO: read from user node positions to swap
// ------------------------------------------------
printf("Please enter node positions to swap:\t);
scanf("%d %d", &node1, &node2
// ------------------------------------------------
// TO DO: find node-1 position in list 
// this is the the first node (n1) to swap
// ------------------------------------------------
i=1 ;
n1=head;
while(i<node1)
{
              n1=n1_>next;
              i++ ; }
// ------------------------------------------------
// TO DO: find node-2 on list
// this is the the second node (n2) to swap
// ------------------------------------------------

n2=n1 ;
n2=head;
while(i<node2)
{
              n2=n2_>next;
              i++ ;
}

	// print list before swap
	printList(head);
	printf("\n");

	// swap nodes n1 and n2
	swap(n1,n2,head);

	// print list after swap
	printList(head);
	printf("\n");

	//close the file
	fclose(fp);	
	//free the list
	freeList(head);	

	system("pause");
	return(0);
}
