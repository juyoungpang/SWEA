package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p3289_unionfind {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int[] graph;
	
	public static void main(String[] args) throws IOException {
		int TTC = nextInt();

		for (int TC = 1; TC <= TTC; TC++) {
			sb.append("#").append(TC).append(" ");
			
			int n = nextInt();
			int m =nextInt();
			
			graph = new int[n];
			for(int i=0;i<graph.length;i++) {
				graph[i] = i;
			}
			while(m-->0) {
				int act = nextInt();
				int a = nextInt()-1;
				int b = nextInt()-1;
				
				if(act==0) {
					union(a,b);
				} else {
					sb.append(getParent(a)==getParent(b)?1:0);
				}
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
	public static void union(int a, int b) {
		int pA = getParent(a);
		int pB = getParent(b);
		
		if(pA==pB)
			return;
		
		graph[pA] = pB;
	}
	
	public static int getParent(int a) {
		if(a==graph[a]) {
			return a;
		}
		
		return graph[a]=getParent(graph[a]);
	}

	public static int nextInt() throws IOException {
		if (st == null || !st.hasMoreElements()) {
			st = new StringTokenizer(br.readLine());
		}
		return Integer.parseInt(st.nextToken());
	}
}