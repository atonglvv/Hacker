#include<stdio.h>
#include<malloc.h>

#define MAXSIZE 1000

typedef int status; 
typedef char TElemType;
typedef int QElemType;
// 把结构体声明放到前面能不能行了？
typedef struct BiTNode
{
	TElemType data;
	struct BiTNode *lchild,*rchild;
}BiTNode,*BiTree;



// 先序建立二叉树
BiTree CreatBiTree()
{
    char ch;
	scanf("%c",&ch);
	BiTree T=NULL;
    if(ch==' ') {T=NULL;}
	else{
		T=(BiTree)malloc(sizeof(BiTNode)+1);
		T->data=ch;
	    T->lchild=CreatBiTree();
	    T->rchild=CreatBiTree();
	}
	return T;
}


// 二叉树的层序遍历
void LevelOrder(BiTree T)
{
    if (T == NULL) return;

    BiTree q[MAXSIZE];
    q[0] = T;

    int front = 0;
    int rear = 1;

    while (front < rear)
    {
        printf("%c ", q[front]->data);

        if (q[front]->lchild)
            q[rear++] = q[front]->lchild;

        if (q[front]->rchild)
            q[rear++] = q[front]->rchild;

        ++front;
    }
}

int main()
{
	BiTree T; 
	T=CreatBiTree();
	LevelOrder(T);
	return 0;
}