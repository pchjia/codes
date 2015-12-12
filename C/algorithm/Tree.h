#ifndef __Tree__
#define __Tree__

#define ElementType int
#define MAX_SIZE 10
#define StackElementType BinTree*


typedef struct TreeNode{
    ElementType Data;
    struct TreeNode* Left;
    struct TreeNode* Right;
    int Visited;
}BinTree;

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
    }
}

BinTree* Find(BinTree* bt, ElementType X){
    if(!bt){
        return NULL;
    }
    if(X > bt->Data){
        return Find(bt->Right, X);
    }else if(X < bt->Data){
        return Find(bt->Left, X);
    }else{
        return bt;
    }
}

BinTree* IterFind(BinTree* bt, ElementType X){
    while(bt){
        if(X > bt->Data){
            bt = bt->Right;
        }else if(X < bt->Data){
            bt = bt->Left;
        }else{
            return bt;
        }
    }
    return NULL;
}

BinTree* FindMin(BinTree* bt){
    if(!bt){
        return NULL;
    }
    if(bt->Left){
        return FindMin(bt->Left);
    }else{
        return bt;
    }
}

BinTree* FindMax(BinTree* bt){
    if(!bt){
        return NULL;
    }
    if(bt->Right){
        return FindMax(bt->Right);
    }else{
        return bt;
    }
}

BinTree* IterFindMin(BinTree* bt){
    if(!bt){
        return NULL;
    }
    while(bt->Left){
        bt = bt->Left;
    }
    return bt;
}

BinTree* IterFindMax(BinTree* bt){
    if(!bt){
        return NULL;
    }
    while(bt->Right){
        bt = bt->Right;
    }
    return bt;
}

BinTree* TreeInsert(BinTree* bt, ElementType X){
    if(!bt){
        bt = (BinTree*)malloc(sizeof(struct TreeNode));
        bt->Data = X;
        bt->Left = NULL;
        bt->Right = NULL;
    }else{
        if(X < bt->Data){
            bt->Left = TreeInsert(bt->Left, X);
        }else if(X > bt->Data){
            bt->Right = TreeInsert(bt->Right, X);
        }
    }
    return bt;
}

BinTree* Delete(BinTree* bt, ElementType X){
    BinTree* tmp;
    if(!bt){
        return NULL;
    }
    if(X < bt->Data){
        bt->Left = Delete(bt->Left, X);
    }else if(X > bt->Data){
        bt->Right = Delete(bt->Right, X);
    }else{
        if(bt->Left && bt->Right){
            tmp = FindMax(bt->Left);
            bt->Data = tmp->Data;
            bt->Left = Delete(bt->Left, bt->Data);
        }else{
            tmp = bt;
            if(bt->Left){
                bt = bt->Left;
            }else if(bt->Right){
                bt = bt->Right;
            }
            free(tmp);
        }
    }
    return bt;
}

void PostOrderTraversal_(BinTree* bt){
    BinTree* t = bt;
    ArrStack* s = CreateStack();
    while(t || !IsStackEmpty(s)){
        while(t){
            t->Visited = 1;
            Push(s, t);
            t = t->Left;
        }
        if(!IsStackEmpty(s)){
            t = Pop(s);
            if(t->Visited){
                t->Visited = 0;
                Push(s, t);
                t = t->Right;
            }else{
                printf("%d  ", t->Data);
                t = NULL;
            }

        }
        
    }
}

void InOrderTraversal_(BinTree* bt){
    BinTree* t = bt;
    ArrStack* s = CreateStack();
    while(t || !IsStackEmpty(s)){
        while(t){
            Push(s, t);
            t = t->Left;
        }
        if(!IsStackEmpty(s)){
            t = Pop(s);
            printf("%d  ", t->Data);
            t = t->Right;
        }
    }
}

void PreOrderTraversal_(BinTree* bt){
    BinTree* t = bt;
    ArrStack* s = CreateStack();
    while(t || !IsStackEmpty(s)){
        while(t){
            printf("%d  ", t->Data);
            Push(s, t);
            t = t->Left;
        }
        if(!IsStackEmpty(s)){
            t = Pop(s);
            t = t->Right;
        }
    }
}

int IsEmpty(BinTree* bt){
    int flag = 0;
    if(bt->Left == NULL && bt->Right == NULL){
        flag = 1;
    }
    return flag;
}

BinTree* CreateBinTree(){
    BinTree* p = (BinTree*)malloc(sizeof(struct TreeNode));
    p->Left = NULL;
    p->Right = NULL;
    p->Visited = 0;
    return p;
}

void PreOrderTraversal(BinTree* bt){
    if(bt){
        printf("%d  ", bt->Data);
        PreOrderTraversal(bt->Left);
        PreOrderTraversal(bt->Right);
    }
}

void InOrderTraversal(BinTree* bt){
    if(bt){
        InOrderTraversal(bt->Left);
        printf("%d  ", bt->Data);
        InOrderTraversal(bt->Right);
    }
}

void PostOrderTraversal(BinTree* bt){
    if(bt){
        PostOrderTraversal(bt->Left);
        PostOrderTraversal(bt->Right);
        printf("%d  ", bt->Data);
    }
}

#endif
