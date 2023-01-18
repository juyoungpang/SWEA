package D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1979_iteration {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer tok = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(tok.nextToken());
			int K = Integer.parseInt(tok.nextToken());

			int[][] arr = new int[N][N];
			for(int i=0;i<N;i++) {
				tok = new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					arr[i][j] = Integer.parseInt(tok.nextToken());
				}
			}
			
			int answer = 0;
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(arr[i][j]==1) {
						if((j==0 || arr[i][j-1]==0) && j+K<=N) { // 왼쪽
							boolean possible = true;
							for(int k=0;k<K;k++) {
								if(arr[i][j+k] == 0) {
									possible=false;
									break;
								}
							}
							if(possible && (j+K==N || arr[i][j+K]==0)) answer++;
						}
						
						if((i==0 || arr[i-1][j]==0) && i+K<=N) { // 아래쪽
							boolean possible = true;
							for(int k=0;k<K;k++) {
								if(arr[i+k][j] == 0) {
									possible=false;
									break;
								}
							}
							if(possible && (i+K==N || arr[i+K][j]==0)) answer++;
						}
					}
				}
			}
			
			System.out.printf("#%d %d%n", test_case, answer);
		}
	}
}