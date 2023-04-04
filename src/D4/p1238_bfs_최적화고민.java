package D4;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class p1238_bfs_최적화고민 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	public static void run() throws IOException {
		boolean[] visited = new boolean[101];
		List<Integer>[] contacts = new List[101];
		int maxDepth = 0, maxVal = 0;
		
		for(int i=0;i<contacts.length;i++) {
			contacts[i] = new ArrayList<>();
		}
		
		int m = nextInt();
		int start = nextInt();
		
		for(int i=0;i<m;i+=2) {
			int from = nextInt();
			int to = nextInt();
			
			contacts[from].add(to);
		}
		
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {start,0});		
		visited[start] = true;
		
		while(!q.isEmpty()) {
			int[] node = q.poll();
			
			for(int contact:contacts[node[0]]) {
				if(visited[contact]) 
					continue;
				
				if(node[1]+1==maxDepth) {
					maxVal = Math.max(maxVal, contact);
				} else if (node[1]+1>maxDepth) {
					maxDepth = node[1]+1;
					maxVal = contact;
				}
				
				visited[contact] = true;
				q.offer(new int[] {contact, node[1]+1});
			}
		}
		
		sb.append(maxVal).append("\n");
	}

	public static void main(String[] args) throws IOException {
		for(int i=1;i<=10;i++) {
			sb.append("#").append(i).append(" ");
			run();
		}
		
		System.out.println(sb.toString());
	}
	
	public static int nextInt() throws IOException {
		if(st==null || !st.hasMoreElements()) {
			st = new StringTokenizer(br.readLine());
		}
		return Integer.parseInt(st.nextToken());
	}
}