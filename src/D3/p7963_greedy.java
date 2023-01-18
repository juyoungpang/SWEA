package D3;

import java.util.Scanner;

public class p7963_greedy {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			
			int N = sc.nextInt();
			int D = sc.nextInt();
			
			int[] arr = new int[N+2];
			arr[0] = 1;
			arr[N+1] = 1;
			
			for(int i=1;i<=N;i++) {
				arr[i] = sc.nextInt();
			}
			
			int answer = 0;
			int dist = 0;
			for(int i=0;i<arr.length;i++) {
				if(arr[i]==1) {
					dist=1;
					continue;
				}
				
				dist++;
				
				if(dist>D) {
					answer++;
					dist=1;
				}
			}

			System.out.printf("#%d %d%n", test_case, answer);
		}
	}
}