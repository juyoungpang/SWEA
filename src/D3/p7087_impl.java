package D3;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p7087_impl {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(br.readLine());
			int[] alphabets = new int[26];
			
			for(int i=0;i<N;i++) {
				int a = br.readLine().charAt(0) - 'A';
				alphabets[a]++;
			}

			int answer=0;
			for(int a:alphabets) {
				if(a==0) break;
				answer++;
			}
			
			System.out.printf("#%d %d%n", test_case, answer);
		}
	}
}