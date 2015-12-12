#ifndef __Stack__
#define __Stack

#include"Tree.h"

#define MAX_SIZE 10
#define StackElementType BinTree*

typedef struct Stack{
    StackElementType Data[MAX_SIZE];
    int Size;
    int top;
}ArrStack;

int IsFull(ArrStack* p){
    int flag = 0;
    if(p->top == MAX_SIZE - 1){
        flag = 1;
    }
    return flag;
}

int IsStackEmpty(ArrStack* p){
    int flag = 0;
    if(p->top == 0){
        flag = 1;
    }
    return flag;
}

ArrStack* CreateStack(){
    ArrStack* p = (ArrStack*)malloc(sizeof(struct Stack));
    p->top = 0;
    p->Size = MAX_SIZE;
}

void Push(ArrStack* p, StackElementType item){
    if(IsFull(p)){
        printf("Stack is full");
        return;
    }else{
        p->Data[p->top] = item;
        p->top++;
    }

}

StackElementType Pop(ArrStack* p){
    if(IsStackEmpty(p)){
        printf("Stack is empty");
        return NULL;
    }else{
        StackElementType item;
        item = p->Data[p->top-1];
        p->top--;
        return item;
    }
}

#endif
