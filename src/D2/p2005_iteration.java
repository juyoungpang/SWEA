package D2;

import java.util.Scanner;

public class p2005_iteration {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			System.out.printf("#%d%n", test_case);
			
			int N = sc.nextInt();
			int[][] arr= new int[N][N];
			arr[0][0] = 1;
			System.out.println(1);
			for(int i=1;i<N;i++) {
				for(int j=0;j<i+1;j++) {
					arr[i][j] = (j-1>=0?arr[i-1][j-1]:0)+arr[i-1][j];
					System.out.print(arr[i][j]+" ");
				}
				System.out.println();
			}
		}
	}
}