package programmers.구슬을나누는경우의수;

/*
 머쓱이는 구슬을 친구들에게 나누어주려고 합니다. 
 구슬은 모두 다르게 생겼습니다. 
 머쓱이가 갖고 있는 구슬의 개수 balls와 친구들에게 나누어 줄 구슬 개수 share이 매개변수로 주어질 때, 
 balls개의 구슬 중 share개의 구슬을 고르는 가능한 모든 경우의 수를 return 하는 solution 함수를 완성해주세요.
 */

 /*
풀이법 : factorial 함수를 만들어
BigInteger 사용 :: 무한대까지 저장 가능
  */


import java.math.*;
public class Main {
    public static void main(String[] args){
        int balls = 5;
        int share = 3;

        solution(balls, share);

    }

    public static BigInteger solution(int balls, int share){
        return factorial(balls).divide(factorial(balls - share).multiply(factorial(share)));
    }

    public static BigInteger factorial(int n){
        BigInteger ret = new BigInteger("1");
        BigInteger from = new BigInteger("1");
        BigInteger to = new BigInteger(String.valueOf(n));

        for (BigInteger i=from; i.compareTo(to) <= 0; i = i.add(BigInteger.ONE))
            ret = ret.multiply(i);

        return ret;
    }
    
}
