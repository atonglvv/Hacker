#include<stdio.h>
int Q[100];
int Head,Tail,Number_of_Item = 0;

void Enqueue(int x){
	if(Number_of_Item == 0){
		Head = Tail =0;
		Q[0] = x;
	}else{
		Tail = (Tail + 1) % 100;
		Q[Tail] = x;
	}
	Number_of_Item++;
}

int Dequeue(){
	int z;
	z = Q[Head];
	Head = (Head + 1) % 100;
	Number_of_Item--;
	return z;
}

int main(){
	int n,i,j,answer;
	printf("Enter an Integer (1-99) : ");
	scanf("%d",&n);

	/*Solve Josephus Problem*/
	/*Setp1 : Put all the number between 1 and n to the Queue */
	for(i = 1; i <= n; i++){
		Enqueue(i);
	}


	/*Sept2 : Start killing for n-1 rounds */
	for(i = 1; i <= n-1; i++){
		j = Dequeue();
		Dequeue();
		Enqueue(j);
	}

	answer = Q[Head];

	printf("The Value of J[%d] is : %d\n", n, answer);

	return 0;
}


