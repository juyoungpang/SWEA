import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p11315_for { 

	static int[] dr = { 0, 1, 1, 1 };
	static int[] dc = { 1, 1, 0, -1 };

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(br.readLine());
			char[][] board = new char[N][N];
			for (int i = 0; i < N; i++) {
				String temp = br.readLine();
				for (int j = 0; j < N; j++) {
					board[i][j] = temp.charAt(j);
				}
			}

			boolean answer = false;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (board[i][j] == 'o') {
						for (int d = 0; d < dr.length; d++) {
							int r = i;
							int c = j;
							for (int x = 0; x < 4; x++) {
								int newR = r + dr[d];
								int newC = c + dc[d];

								if (newR < 0 || newC < 0 || newR >= N || newC >= N || board[newR][newC]!='o')
									break;
								
								r = newR;
								c = newC;
								
								if(x==3) answer = true;
							}
							if(answer) break;
						}
						if(answer) break;
					}
					if(answer) break;
				}
				if(answer) break;
			}

			System.out.printf("#%d %s%n", test_case, answer?"YES":"NO");
		}
	}
}