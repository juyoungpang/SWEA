package D3;

import java.util.Scanner;

public class p6485_impl {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(test_case).append(" ");
			
			int[] stations = new int[5001];
			
			int N = sc.nextInt();
			
			for(int i=0;i<N;i++) {
				int A = sc.nextInt();
				int B = sc.nextInt();
				
				for(int j=A;j<=B;j++) {
					stations[j]++;
				}
			}
			
			int P = sc.nextInt();
			
			for(int i=0;i<P;i++) {
				sb.append(stations[sc.nextInt()]).append(" ");
			}
			
			System.out.println(sb);
			
		}
	}
}