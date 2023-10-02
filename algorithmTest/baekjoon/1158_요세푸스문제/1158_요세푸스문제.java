import java.util.*;
import java.io.*;


class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> queue = new LinkedList<Integer>();

        String []numbers = br.readLine().split(" ");
        int personCount = Integer.parseInt(numbers[0]);
        int deleteCount = Integer.parseInt(numbers[1]);
        int cnt = 1;

        for (int i=1; i<=personCount; i++){
            queue.offer(i);
        }
        System.out.print("<");
        while (!queue.isEmpty()){
            if (cnt++ % deleteCount == 0){
                if (queue.size() != 1){
                    System.out.print(queue.poll()+", ");
                }else{
                     System.out.print(queue.poll());
                }
                
            }else{
                queue.offer(queue.poll());
            }
        }
        System.out.print(">");

    }
    
}
