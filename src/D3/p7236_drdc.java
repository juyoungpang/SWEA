package D3;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p7236_drdc {
	
	//상,하,좌,우,상좌,상우,하좌,하우
	static int[] dr = {-1,1,0,0,-1,-1,1,1};
	static int[] dc = {0,0,-1,1,-1,1,-1,1};
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(br.readLine());
			char[][] map = new char[N][N];
			
			for(int i=0;i<N;i++) {
				StringTokenizer tok = new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					map[i][j] = tok.nextToken().charAt(0);
				}
			}
			
			int answer = 0;			
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					int depth = 0;
					for(int d=0;d<dr.length;d++) {
						int newI = i+dr[d];
						int newJ = j+dc[d];
						
						if(newI<0 || newJ<0 || newI>=N || newJ>=N) continue;
						
						if(map[newI][newJ]=='W') depth++;
					}
					if(depth==0) depth=1;
					
					answer = Math.max(answer, depth);
				}
			}

			System.out.printf("#%d %d%n", test_case, answer);
		}
	}
}