import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p1289_iteration {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			char currentState = '0';
			int answer = 0;
			String input = br.readLine();
			for (int i = 0; i < input.length(); i++) {
				if (input.charAt(i) != currentState) {
					answer++;
					currentState = input.charAt(i);
				}
			}

			System.out.printf("#%d %d%n", test_case, answer);
		}
	}
}