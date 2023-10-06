import java.util.Arrays;

public class ReadMeTest {
    public static void main(String[] args){
        int []number = {1, 2, 3, 4, 5};

        int arr[] = Arrays.copyOfRange(number, 0, 3);

        for (int i=0; i<arr.length; i++)
            System.out.println(arr[i]);
    }
}
