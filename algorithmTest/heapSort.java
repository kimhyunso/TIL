public class heapSort{

    public static void main(String[] args){
        int heap[] = {7, 6, 5, 8, 3, 5, 9, 1, 6};

        // 먼저 전체 트리 구조를 '최대힙' 구조로 바꿉니다.
        for (int i=1; i<heap.length; i++){
            int child = i;

            // root에 도달하면 모든 값이 바뀌어 있기 때문에 0 (root node인덱스) 이면 탈출
            do{
                // 부모노드를 알 수 있음 ex : (3 -1) / 2 = 1, (4 -1) / 2 = 1, (5-1) / 2 = 2, (6-1) / 2 = 2 ....
                // 자기자신에서 1을 빼고 나눈 값 = 부모노드번호
                int root = (child - 1) / 2; 


                if (heap[root] < heap[child]){
                    int temp = heap[root];
                    heap[root] = heap[child];
                    heap[child] = temp;
                }
                
                // 자식이 부모로 이동하여 반복실행
                child = root;
            }while(child != 0);
        }

        for (int i=0; i<heap.length; i++)
            System.out.print(heap[i] + " ");
        
        System.out.println();


        // 크기를 줄여가며 반복적으로 힙을 구성
        for (int i=heap.length -1 ; i>=0; i--){
            int temp = heap[0];
            heap[0] = heap[i];
            heap[i] = temp;

            int root = 0;
            int child = 1;
            // 자식노드가 i보다 작을 때까지 반복
            do {
                // root의 자식요소
                child = 2 * root + 1;
                // 자식 중에 더 큰 값을 찾기
                if (child < i-1 && heap[child] < heap[child + 1]){
                    child ++;
                }
                // 루트보다 자식이 더 크다면 교환
                if (child < i && heap[root] < heap[child]){
                    temp = heap[child];
                    heap[child] = heap[root];
                    heap[root] = temp;
                }

                root= child;
            }while(child < i);
        }

        for (int i=0; i<heap.length; i++)
            System.out.print(heap[i] + " ");


    }

}