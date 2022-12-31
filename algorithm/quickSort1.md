# 정렬 알고리즘
```c
#include<stdio.h>

void QuickSort(int quick[],int left,int right);
int Partition(int quick[],int left,int right);
void Swap(int quick[],int a,int b);

int main(){
	int quick[100];
	int i;	
	int n;

	srand(time(0));
	for(i=0; i<6; i++){
		quick[i]=rand()%50+1;
	}

	printf("Count Num : ");
	scanf("%d",&n);

	QuickSort(quick,0,n-1);

	for(i=0; i<6; i++){
		printf("QuickSort : %d",quick[i]);
		if(i/5==1)printf("\n");
	}
}

void Swap(int quick[],int a,int b){
	int temp=quick[a];
	quick[a]=quick[b];
	quick[b]=temp;
}

int Partition(int quick[],int left,int right){
	int pivot = quick[left]; //pivot left start
	int low = left+1;
	int high = right;
	while(low<=high){
		while(pivot>=quick[low]&&low<=right){
			low++;
		}
		while(pivot<=quick[high]&&high>=(left+1)){
			high--;
		}
		if(low <= high){
			Swap(quick,low,high);
		}
	}
	Swap(quick,low,high);
	return high;
}

void QuickSort(int quick[],int left,int right){
	if(left<=right){
		int pivot = Partition(quick,left,right);//quick/2  pivot 
		QuickSort(quick,left,pivot-1); //left area
		QuickSort(quick,pivot+1,right);//right area
	}

}
```
