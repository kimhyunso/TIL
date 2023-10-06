/*
다음과 같은 n*n 배열 구조를 출력해보자.

입력이 3인 경우 다음과 같이 출력한다.
1 2 3
6 5 4
7 8 9

입력이 5인 경우는 다음과 같이 출력한다.
1 2 3 4 5
10 9 8 7 6
11 12 13 14 15
20 19 18 17 16
21 22 23 24 25

입력이 n인 경우의 2차원 배열을 출력해보자.
 */

/*
풀이법 : 
인덱스가 홀수 일때는 0부터 n까지 증가연산
인덱스가 짝수 일때는 n부터 0까지 증감연산
 */

import java.util.*;

class Main{
	public static void main(String[] args){

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int [][]matrix = new int[N][N];
		int cnt = 1;


		for (int i = 0; i<matrix.length; i++){


			if (i % 2 == 0){
				for (int j = 0; j<matrix[i].length; j++){
					matrix[i][j] = cnt;
					cnt ++;
				}

			}else{
				
				for (int j = matrix[i].length-1; j>=0; j--){
					matrix[i][j] = cnt;
					cnt ++;
				}

			}


			for (int j=0; j<matrix[i].length; j++){

				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
			
		}

	}

}