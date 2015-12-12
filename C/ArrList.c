#include<stdio.h>
#include<stdlib.h>

#define MAX_SIZE 10
#define ElementType int

typedef struct{
    ElementType data[MAX_SIZE];
    int size;
}ArrList;

ArrList* CreateArrList();
void Put(ArrList* al, ElementType item);
ElementType Get(ArrList* al, int n);
void Delete(ArrList* al, ElementType item);
 
int main(int argc, const char *argv[])
{
    ArrList* al = CreateArrList();
    int i;
    for(i=0; i<MAX_SIZE; i++){
        Put(al, i);
    }
    Delete(al, 3);
    Delete(al, 8);
    for(i=0; i<al->size; i++){
        printf("%d\t", Get(al, i));
    }
    return 0;
}



void Put(ArrList* al, ElementType item){
    if(al->size == MAX_SIZE){
        printf("ArrayList is full!\n");
        return;
    }
    al->data[al->size] = item;
    al->size ++;
}

ArrList* CreateArrList(){
    ArrList* al = (ArrList*)malloc(sizeof(ArrList));
    al->size = 0;
    return al;
}

ElementType Get(ArrList* al, int n){
    if(n > MAX_SIZE-1){
        return -1;
    }
    return al->data[n];
}

void Delete(ArrList* al, ElementType item){
    int i;
    int j;
    for(i=0; i<MAX_SIZE; i++){
        if(al->data[i] == item){
            for(j=i; j<al->size; j++){
                al->data[j] = al->data[j+1];
            }
            al->size--;
            break;
        }
    }
}
