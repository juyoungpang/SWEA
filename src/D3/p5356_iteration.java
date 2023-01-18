package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p5356_iteration {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			char[][] arr = new char[5][];
			
			int maxLen = 0;
			
			for(int i=0;i<5;i++) {
				String temp = br.readLine();
				maxLen = Math.max(maxLen, temp.length());
				arr[i] = new char[temp.length()];
				for(int j=0;j<temp.length();j++) {
					arr[i][j] = temp.charAt(j);
				}
			}
			
			StringBuilder sb = new StringBuilder();
			for(int i=0;i<maxLen;i++) {
				for(int j=0;j<5;j++) {
					if(arr[j].length<=i) continue;
					sb.append(arr[j][i]);
				}
			}
			
			System.out.printf("#%d %s%n", test_case, sb);
		}
	}
}