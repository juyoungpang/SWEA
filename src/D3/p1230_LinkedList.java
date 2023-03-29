package D3;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class p1230_LinkedList {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static LinkedList<Integer> ls;

	public static void main(String[] args) throws IOException {
		int TTC = 10;
		for (int TC = 1; TC <= TTC; TC++) {
			sb.append("#").append(TC).append(" ");

			int N = nextInt();
			ls = new LinkedList<>();
			for (int n = 0; n < N; n++) {
				ls.addLast(nextInt());
			}

			int M = nextInt();
			for (int m = 0; m < M; m++) {
				String command = nextString();
				switch (command) {
				case "I":
					insert();
					break;
				case "D":
					delete();
					break;
				case "A":
					add();
					break;
				}
			}
			
			for(int i=0;i<10;i++) {
				sb.append(ls.removeFirst()).append(" ");
			}
			
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
	public static void insert() throws IOException {
		int x = nextInt();
		int y = nextInt();
		for(int s=0;s<y;s++) {
			ls.add(x++,nextInt());
		}
	}
	
	public static void delete() throws IOException {
		int x = nextInt();
		int y = nextInt();
		
		for(int i=0;i<y;i++) {
			ls.remove(x);
		}
	}
	
	public static void add() throws IOException {
		int y = nextInt();
		for(int s=0;s<y;s++) {
			ls.add(nextInt());
		}
	}

	public static int nextInt() throws IOException {
		if (st == null || !st.hasMoreElements())
			st = new StringTokenizer(br.readLine());
		return Integer.parseInt(st.nextToken());
	}
	public static String nextString() throws IOException {
		if (st == null || !st.hasMoreElements())
			st = new StringTokenizer(br.readLine());
		return st.nextToken();
	}
}