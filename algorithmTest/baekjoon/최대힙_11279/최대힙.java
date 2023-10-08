
import java.util.*;
class 최대힙{

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		int heap[] = new int[testCase];
		int cnt = 0; 

		for (int i=0; i<testCase; i++){

			int value = sc.nextInt();
			int root = 0;
			int child = heap.length - 1;
			
			if (value == 0){

				System.out.println(heap[value]);
				heap[value] = 0;

				do{
					root = (child - 1) / 2;
					child = bigNumber(heap, child); 
					swap(heap, root, child);
					child = root;
				}while (child != 0);


			}else{
				heap[cnt++] = value;

				do{
					root = (child - 1) / 2;
					child = bigNumber(heap, child); 
					swap(heap, root, child);
					child = root;
				}while (child != 0);

			}			

		}
	
	}


	public static int bigNumber(int heap[], int child){
		if (heap[child-1] < heap[child])
			return child;
		return --child;
	}

	public static void swap(int heap[], int root, int child){
		int temp = 0; 
		if (heap[root] < heap[child]){
			temp = heap[root];
			heap[root] = heap[child];
			heap[child] = temp;
		}

	}



}