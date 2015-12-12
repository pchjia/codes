#ifndef __AVLTree__
#define __AVLTree__

typedef int AVLTreeElemType

typedef struct AVLTreeNode{
    AVLTreeElemType Data;
    int Height;
    struct AVLTreeNode* Left;
    struct AVLTreeNode* Right;
}AVLTree;

AVLTree* CreateAVLTree(AVLTreeElemType item=0, AVLTree* left=NULL, ALVTree* right=NULL){
    AVLTree* p = (AVLTree*)malloc(sizeof(struct AVLTreeNode));
    p->Data = item;
    p->Left = left;
    p->Right = right;
    p->Height = 0;
}

int AVLTreeHeight(AVLTree* p){
    int height = 0;
    if(p){
        height = p->Height;
    }
    return height;
}

AVLTree* LLRotation(AVLTree* p){
    AVLTree* tmp;
    tmp = p->Left;
    p->Left = tmp->Right;
    tmp->Right = p;
    
    p->Height = max(p->Left->Height,  p->Right->Height) + 1;
    tmp->Height = man(tmp->Left->Height, tmp->Right->Height) - 1;

    return tmp;
}

AVLTree* RRRotation(AVLTree* p){
    AVLTree* tmp;
    tmp = p->Right;
    p->Right = tmp->Left;
    tmp->Left = p;

    p->Height = max(p->Left->Height,  p->Right->Height) + 1;
    tmp->Height = man(tmp->Left->Height, tmp->Right->Height) - 1;

    return tmp;
}

AVLTree* LRRotation(AVLTree* p){
    p->Left = RRRotation(p->Left);
    return LLRotation(p);
}

AVLTree* RLRotation(AVLTREE* p){
    p->Right = LLRotation(p->Right);
    return RRRotation(p);
}

AVLTree* AVLTreeInsert(AVLTree* p, AVLTreeElemType item){
    if(!p){
        p = CreateAVLTree(item);
        
    }else if(item < p->Data){
        p->Left = AVLTreeInsert(p->Left, item);
        if(p->Left->Height - p->Right->Height == 2){
            if(item < p->Left->Data){
                p = LLRotation(p);
            }else{
                p = LRRotation(p);
            }
        }
    }else if(item > p->Data){
        p->Right = AVLTreeInsert(p->Tight, item);
        if(p->Left->Height - p->Right->Height == -2){
            if(item < p->Right->Data){
                p = RLRotation(p);
            }else{
                p = RRRotation(p);
            }
        }
    }
    p->Height = max(p->Left->Height, p->Right->Height) + 1;
    return p;
}

AVLTree* AVLTreeDelete(AVLTree* p, AVLElemType item){

}


#endif
