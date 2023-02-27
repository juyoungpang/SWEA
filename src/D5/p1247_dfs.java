package D5;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1247_dfs {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int N, answer;
	static int[] x,y,chosen;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		int TTC = nextInt();
		for(int TC=1;TC<=TTC;TC++) {
			sb.append("#").append(TC).append(" ");
			
			answer = Integer.MAX_VALUE;
			N = nextInt();
			x = new int[N+2];
			y = new int[N+2];
			chosen = new int[N+2];
			visited = new boolean[N];
			
			// 회사 좌표
			x[0] = nextInt();
			y[0] = nextInt();
			
			// 집 좌표
			x[N+1] = nextInt();
			y[N+1] = nextInt();
			
			// 고른 것 맨앞 맨 뒤 정해놓기
			chosen[0] = 0;
			chosen[N+1] = N+1;
			
			for(int i=1;i<=N;i++) {
				x[i] = nextInt();
				y[i] = nextInt();
			}
			
			dfs(1,0);
			sb.append(answer).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	public static void dfs(int depth, int dist) {
		if(depth==N+1) { 
			answer = Math.min(answer, dist+dist(x[chosen[depth]], x[chosen[depth-1]], y[chosen[depth]], y[chosen[depth-1]]));
			return;
		}
		
		for(int i=1;i<=N;i++) {
			if(visited[i-1]) {
				continue;
			}
			
			visited[i-1] = true;
			chosen[depth] = i;
			dfs(depth+1, dist+dist(x[chosen[depth]], x[chosen[depth-1]], y[chosen[depth]], y[chosen[depth-1]]));
			visited[i-1] = false;
		}
		
	}
	
	public static int dist(int x1, int x2, int y1, int y2) {
		return Math.abs(x1-x2)+Math.abs(y1-y2);
	}

	public static int nextInt() throws IOException {
		if (st == null || !st.hasMoreElements()) {
			st = new StringTokenizer(br.readLine());
		}
		return Integer.parseInt(st.nextToken());
	}
}