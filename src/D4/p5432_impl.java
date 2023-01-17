import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p5432_impl {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			String str = br.readLine();
			
			int answer = 0;
			int bars = 0;
			
			for(int i=0;i<str.length()-1;i++) {
				if(str.charAt(i)=='(' && str.charAt(i+1)==')') {
					answer += bars;
					i++;
				} else if (str.charAt(i)=='(') {
					answer++;
					bars++;
				} else {
					bars--;
				}
			}

			System.out.printf("#%d %d%n", test_case, answer);
		}
	}
}