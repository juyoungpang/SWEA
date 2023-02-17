package D2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p2001_bruteForce {
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TTC = Integer.parseInt(br.readLine());

		for (int TC = 1; TC <= TTC; TC++) {
			int answer = -1;
			
			StringTokenizer tok = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(tok.nextToken());
			int M = Integer.parseInt(tok.nextToken());

			int[][] flies = new int[N][N];
			for (int i = 0; i < N; i++) {
				tok = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					flies[i][j] = Integer.parseInt(tok.nextToken());
				}
			}
						
			for(int i=0;i+M<=N;i++) {
				for(int j=0;j+M<=N;j++) {
					int sum = 0;
					
					for(int a=0;a<M;a++) {
						for(int b=0;b<M;b++) {
							sum+=flies[i+a][j+b];
						}
					}
					
					answer = Math.max(answer, sum);
				}
			}
			
			sb.append("#").append(TC).append(" ").append(answer).append("\n");
		}
		
		System.out.println(sb.toString());
	}
}