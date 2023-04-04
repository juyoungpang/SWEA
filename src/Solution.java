import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	public static void run() {
		
	}
	
	public static void main(String[] args) throws IOException {
		int TTC = nextInt();
		for(int TC=1;TC<=TTC;TC++) {
			sb.append("#").append(TC).append(" ");
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