package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1220_iteration {

	static final int B = 100; // board size
	
	static final int NULL = 0; // 빈칸
	static final int MOVINGDOWN = 1; // north --> 위로 움직이게됨
	static final int MOVINGUP = 2; // south --> 아래로 움직이게됨
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = 10;

		int[][] board;
		boolean[][] checked;

		for (int test_case = 1; test_case <= T; test_case++) {
			br.readLine();
//			initialize board
			board = new int[B][B];
			checked = new boolean[B][B];
			for (int i = 0; i < B; i++) {
				StringTokenizer tok = new StringTokenizer(br.readLine());
				for (int j = 0; j < B; j++) {
					board[i][j] = Integer.parseInt(tok.nextToken());
				} // end of for
			} // end of for

//			solve
			int answer = 0;
			
			for(int c = 0;c<B;c++) {
				int state = NULL;
				for(int r=0;r<B;r++) {
					if(board[r][c]==MOVINGDOWN) {
						if(state != MOVINGDOWN) { // 위에 블럭(들)이 올라가고 있던 상황
							state = MOVINGDOWN;
						}
					} else if(board[r][c]==MOVINGUP) {
						if(state==NULL) { // 올라가는 경우, 처음으로 나온 블럭이라면 무조건 가능
							continue;
						}
						if(state == MOVINGDOWN) { // 현재 위에서 내려오는 블럭이 있는 경우
							answer++;
						}
						state = MOVINGUP;
					}
				}
			}
			

			System.out.printf("#%d %d%n", test_case, answer);

		} // end of test for
	} // end of main
} // end of class