import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 수찾기 {

    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String number1[] = br.readLine().split(" ");

        int M = Integer.parseInt(br.readLine());
        String number2[] = br.readLine().split(" ");
        boolean flag = false;

        for (int i =0; i<M; i++){
            String num = number1[i];
            for (int j=0; j<N; j++){
                 if (num.equals(number2[i])){
                    System.out.println(1);
                    flag = false;
                    break;
                }else{
                    flag = true;
                }

            }

            if (flag)
                System.out.println(0);
        }
    }

    
}
