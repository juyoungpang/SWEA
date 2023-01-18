package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p2805_iteration {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(br.readLine());
			int[][] arr = new int[N][N];
			
			for(int i=0;i<N;i++) {
				String temp = br.readLine();
				for(int j=0;j<N;j++) {
					arr[i][j] = temp.charAt(j)-'0';
				}
			}
			
			int size = 1;
			int center = N/2;
			boolean increasing = true;
			
			int answer = 0;
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<size;j++) {
					answer += arr[i][center-(size/2)+j];
				}
				
				if(size==N) increasing=false;
				
				if(increasing) size+=2;
				else size -= 2;
			}

			System.out.printf("#%d %d%n", test_case, answer);
		}
	}
}