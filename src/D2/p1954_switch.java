package D2;

import java.util.Scanner;

public class p1954_switch {
	static final int RIGHT = 0;
	static final int DOWN = 1;
	static final int LEFT = 2;
	static final int UP = 3;

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			System.out.printf("#%d%n", test_case);

			int N = sc.nextInt();
			int[][] arr = new int[N][N];

			int direction = RIGHT;

			int r = 0;
			int c = 0;
			for (int i = 1; i <= N * N; i++) {
				arr[r][c] = i;

				switch (direction) {
				case RIGHT:
					if (c + 1 == N || arr[r][c + 1] != 0) {
						direction++;
						r++;
					} else
						c++;
					break;
				case DOWN:
					if (r + 1 == N || arr[r + 1][c] != 0) {
						direction++;
						c--;
					} else
						r++;
					break;
				case LEFT:
					if (c - 1 == -1 || arr[r][c - 1] != 0) {
						direction++;
						r--;
					} else
						c--;
					break;
				case UP:
					if (r - 1 == -1 || arr[r - 1][c] != 0) {
						direction = 0;
						c++;
					} else
						r--;
					break;
				}
			}

			for (int[] a : arr) {
				for (int n : a) {
					System.out.print(n + " ");
				}
				System.out.println();
			}
		}
	}
}