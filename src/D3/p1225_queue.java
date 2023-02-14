package D3;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class p1225_queue {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int TTC = 10;
		
		for(int TC = 1; TC<=TTC; TC++) {
			Queue<Integer> q = new ArrayDeque<>();
			
			br.readLine();
			StringTokenizer tok = new StringTokenizer(br.readLine());
			for(int i=0;i<8;i++) {
				q.add(Integer.parseInt(tok.nextToken()));
			}
			
			int sub = 1;
			while(true) {
				int polled = q.poll();
				polled-=sub++;
				
				if(sub>5) {
					sub=1;
				}
				if(polled<=0) {
					q.add(0);
					break;
				}
				
				q.add(polled);
			}
			
			sb.append("#").append(TC).append(" ");
			for(int i=0;i<8;i++) {
				sb.append(q.poll()).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
}