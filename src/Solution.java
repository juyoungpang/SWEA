import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tok;
	static StringBuilder sb = new StringBuilder();

	// U, D, L, R
	static int[][] drdc = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static char[][] map;
	static int H, W, N;
	static String input;
	static Tank tank;

	static class Tank {
		int r;
		int c;
		int d;

		public Tank(int r, int c, int d) {
			this.r = r;
			this.c = c;
			this.d = d;
		}

		public void rotate(int d) {
			this.d = d;
			move();
		}

		public void move() {
			int newR = r + drdc[d][0];
			int newC = c + drdc[d][1];
			if (isValid(newR, newC) && map[newR][newC] == '.') {
				r = newR;
				c = newC;
			}
		}
	}

	public static boolean isValid(int r, int c) {
		return r >= 0 && r < H && c >= 0 && c < W;
	}

	public static void shoot() {
		int r = tank.r;
		int c = tank.c;
		while (map[r][c] != '*' && map[r][c] != '#') {
			r += drdc[tank.d][0];
			c += drdc[tank.d][1];

			if (!isValid(r, c))
				return;
		}
		if (map[r][c] == '*')
			map[r][c] = '.';
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		int TTC = Integer.parseInt(br.readLine());
		for (int TC = 1; TC <= TTC; TC++) {
			sb.append("#").append(TC).append(" ");

			tok = new StringTokenizer(br.readLine());
			H = Integer.parseInt(tok.nextToken());
			W = Integer.parseInt(tok.nextToken());

			map = new char[H][W];
			for (int i = 0; i < H; i++) {
				String temp = br.readLine();
				for (int j = 0; j < W; j++) {
					map[i][j] = temp.charAt(j);

					switch (map[i][j]) {
					case '^':
						map[i][j] = '.';
						tank = new Tank(i, j, 0);
						break;
					case 'v':
						map[i][j] = '.';
						tank = new Tank(i, j, 1);
						break;
					case '<':
						map[i][j] = '.';
						tank = new Tank(i, j, 2);
						break;
					case '>':
						map[i][j] = '.';
						tank = new Tank(i, j, 3);
						break;
					}
				}
			}

			N = Integer.parseInt(br.readLine());
			input = br.readLine();

			for (int n = 0; n < N; n++) {
				switch (input.charAt(n)) {
				case 'U':
					tank.rotate(0);
					break;
				case 'D':
					tank.rotate(1);
					break;
				case 'L':
					tank.rotate(2);
					break;
				case 'R':
					tank.rotate(3);
					break;
				case 'S':
					shoot();
					break;
				}
			}

			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					if (i == tank.r && j == tank.c) {
						if (tank.d == 0) {
							sb.append('^');
						} else if (tank.d == 1) {
							sb.append('v');
						} else if (tank.d == 2) {
							sb.append('<');
						} else {
							sb.append('>');
						}
					} else {
						sb.append(map[i][j]);
					}
				}
				sb.append("\n");
			}
		}
		System.out.println(sb.toString());
	}
}