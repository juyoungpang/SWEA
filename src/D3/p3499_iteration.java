import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p3499_iteration {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(br.readLine());
			String[] arr = br.readLine().split(" ");
			
			StringBuilder sb = new StringBuilder();
			for(int i=0;i<N/2;i++) {
				sb.append(arr[i]).append(" ").append(arr[i+(int)Math.ceil(N/2.0)]).append(" ");
			}
			
			if(N%2!=0) sb.append(arr[N/2]).append(" ");
			
			sb.setLength(sb.length()-1);
			
			System.out.printf("#%d %s%n", test_case, sb);
		}
	}
}