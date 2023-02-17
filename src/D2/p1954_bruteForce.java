package D2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p1954_bruteForce {

	static int[][] snail;
	static StringBuilder sb = new StringBuilder();

	// 우, 하, 좌, 상
	static final int[] dr = { 0, 1, 0, -1 };
	static final int[] dc = { 1, 0, -1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int TTC = Integer.parseInt(br.readLine());

		for (int TC = 1; TC <= TTC; TC++) {
			int N = Integer.parseInt(br.readLine());

			snail = new int[N][N];

			int num = 1;
			int row = 0;
			int col = -1;
			int d = 0;
			
			while (num <= N * N) {
				while (true) {
					int newRow = row + dr[d];
					int newCol = col + dc[d];

					if (newRow < 0 || newCol < 0 || newRow >= N || newCol >= N || snail[newRow][newCol] != 0) {
						d = (d + 1) % 4;
					} else {
						row = newRow;
						col = newCol;
						break;
					}
				}

				snail[row][col] = num++;
			}

			sb.append("#").append(TC).append("\n");

			for (int[] r : snail) {
				for (int n : r) {
					sb.append(n).append(" ");
				}
				sb.append("\n");
			}

		}

		System.out.println(sb.toString());
	}
}