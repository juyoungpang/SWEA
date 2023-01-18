package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p4789_impl {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			String str = br.readLine();
			
			int count = 0;
			int answer = 0;
			for(int i=0;i<str.length();i++) {
				int num = str.charAt(i)-'0';
				if(count>=i) {
					count+=num;
				} else {
					answer+=i-count;
					count+=(i-count)+num;
				}
			}

			System.out.printf("#%d %d%n", test_case, answer);
		}
	}
}