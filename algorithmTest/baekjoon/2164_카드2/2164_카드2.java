import java.util.*;

class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Queue<Integer> queue = new LinkedList<Integer>();
        int cardCount = sc.nextInt();
        
        
        for (int i=1; i<=cardCount; i++){
            queue.offer(i);
        }

        while(queue.size() != 1){
            queue.poll();
            queue.add(queue.poll());
        }

        System.out.print(queue.peek());
    }
}
