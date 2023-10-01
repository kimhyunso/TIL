import java.util.*;


public class Zigzag{
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