#include<stdio.h>
#include<stdlib.h>

#include"Tree.h"

int main(int argc, const char *argv[]){
    BinTree* p = CreateBinTree();
/*    BinTree* tmp;
    tmp = p;
    tmp->Data = 1;
    
    tmp->Left = CreateBinTree();
    tmp->Right = CreateBinTree();

    tmp->Left->Data = 2;
    tmp->Right->Data = 6;

    tmp = p->Left;
    tmp->Left = CreateBinTree();
    tmp->Right = CreateBinTree();
    tmp->Left->Data = 3;
    tmp->Right->Data = 4;

    tmp = p->Left->Right;
    tmp->Left = CreateBinTree();
    tmp->Left->Data = 5;

    tmp = p->Right;
    tmp->Left = CreateBinTree();
    tmp->Right = CreateBinTree();
    tmp->Left->Data = 7;
    tmp->Right->Data = 9;

    tmp = p->Right->Left;
    tmp->Right = CreateBinTree();
    tmp->Right->Data = 8;
    
    PreOrderTraversal(p);
    printf("\n");
    InOrderTraversal(p);
    printf("\n");
    PostOrderTraversal(p);
    printf("\n");
    PreOrderTraversal_(p);
    printf("\n");
    InOrderTraversal_(p);
    printf("\n");
    PostOrderTraversal_(p);
*/
    int i;
    p->Data = 5;
    for(i=1; i<=12; i++){
        p = TreeInsert(p, i);
    }
    PreOrderTraversal(p);
    printf("\n");
    InOrderTraversal(p);
    printf("\n");
    PostOrderTraversal(p);
    printf("\n");
    return 0;
}
