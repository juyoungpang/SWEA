package D3;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p1215_palindrome {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = 10;

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(br.readLine())-1; // 마지막 index 구하기 쉽게 1 빼기
			char[][] board = new char[8][8];
			
			for(int i=0;i<8;i++) {
				String temp = br.readLine();
				for(int j=0;j<8;j++) {
					board[i][j] = temp.charAt(j);
				}
			}

			int answer = 0;
			
			//left to right
			for(int i=0;i<8;i++) {
				for(int j=0;j+N<8;j++) {
					boolean isPalindrome = true;
					int leftIdx = j;
					int rightIdx = j+N;
					
					while(leftIdx < rightIdx) {
						if(board[i][leftIdx]!=board[i][rightIdx]) {
							isPalindrome = false;
							break;
						}
						leftIdx++;
						rightIdx--;
					}
					
					if(isPalindrome) answer++;
				}
			}
			
			//top to bottom
			for(int i=0;i<8;i++) {
				for(int j=0;j+N<8;j++) {
					boolean isPalindrome = true;
					int topIdx = j;
					int bottomIdx = j+N;
					
					while(topIdx < bottomIdx) {
						if(board[topIdx][i]!=board[bottomIdx][i]) {
							isPalindrome = false;
							break;
						}
						topIdx++;
						bottomIdx--;
					}
					
					if(isPalindrome) answer++;
				}
			}
			

			System.out.printf("#%d %d%n", test_case, answer);
		}
	}
}