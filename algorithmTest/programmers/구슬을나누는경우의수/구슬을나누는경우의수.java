package programmers.구슬을나누는경우의수;
import java.util.*;

public class 구슬을나누는경우의수 {
    public static void main(String[] args){
        int balls = 3;
        int share = 2;

        solution(balls, share);

    }

    public static int solution(int balls, int share){
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i=1; i<=balls; i++)
            map.put(i, 1);

        return 0;
    }
}
