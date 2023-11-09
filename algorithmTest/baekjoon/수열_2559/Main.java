

/**
 * 1. 아이디어 
 * - 투포인터를 활용
 * - for문으로 처음에 K개 값을 저장
 * - 다음인덱스 더해주고, 이전 인덱스 빼줌
 * - 이때마다 최대값을 갱신
 * 
 * 2. 시간복잡도
 * - O(N) = 1e5 > 가능
 * 
 * 3. 자료구조
 * - 각 숫자들 N개 저장 배열 : int[]
 *      - 숫자들 최대 100 > INT 가능
 * - K개의 값을 저장 변수 : INT
 *      - 최대 : K * 100 =  1e5 * 100 = 1e7 > INT 가능
 * - 최대값 : int
 * 
 */

import java.util.*;
import java.io.*;
class MainA{
    public static void main(String[] args) throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer token = new StringTokenizer(input.readLine(), " ");
        int day = Integer.parseInt(token.nextToken());
        int count = Integer.parseInt(token.nextToken());
        int temper[] = new int[day];

        String numbers[] = input.readLine().split(" ");
        for (int i=0; i<day; i++){
            temper[i] = Integer.parseInt(numbers[i]);
        }
        int each = 0;
        int max = 0;
        // K개를 더해주기
        for (int i=0; i<count; i++){
            each += temper[i];
        }
        max = each;


        // 다음 인덱스 더해주고, 이전인덱스 빼주기
        for (int i=count; i<day; i++){
            each += temper[i];
            each -= temper[i-count];
            max = Math.max(max, each);
        }
        System.out.println(max);
    }


}