package D2;

import java.util.Scanner;

public class p2001_iteration {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int[][] arr = new int[N][N];
			
			int answer = -1;
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			
			for(int i=0;i+M<=N;i++) {
				for(int j=0;j+M<=N;j++) {
					int total = 0;
					for(int a=0;a<M;a++) {
						for(int b=0;b<M;b++) {
							total += arr[i+a][j+b];
						}
					}
					answer = Math.max(answer, total);
				}
			}

			System.out.printf("#%d %d%n", test_case, answer);
		}
	}
}