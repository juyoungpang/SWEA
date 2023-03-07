import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N, W, H, totalBricks, answer = Integer.MAX_VALUE;
	static List<Integer>[] originalBricks;

	public static void main(String[] args) throws IOException {
		int TTC = nextInt();
		for (int TC = 1; TC <= TTC; TC++) {
			sb.append("#").append(TC).append(" ");

			N = nextInt();
			W = nextInt();
			H = nextInt();
			
			chosen = new int[N];

			originalBricks = new List[W];
			for (int w = 0; w < W; w++) {
				originalBricks[w] = new ArrayList<>();
			}

			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					int brick = nextInt();
					if (brick == 0)
						continue;
					originalBricks[j].add(0, brick);
					totalBricks++;
				}
			}

			rec(0,0);

			sb.append(answer).append("\n");
		}
		System.out.println(sb.toString());
	}

	static List<Integer>[] bricks;
	static int[] chosen;

	public static void rec(int depth, int exploded) {
		if (depth == N) {
			if(chosen[0]==2 && chosen[1]==2 && chosen[2] ==6)
				System.out.println();
			answer = Math.min(answer, (totalBricks - exploded));
			return;
		}

		for (int i = 0; i < W; i++) {
			if(depth==0) {
				bricks = new List[originalBricks.length];
				for(int j=0;j<bricks.length;j++) {
					bricks[j] = new ArrayList<>(originalBricks[j]);
				}
			}
			if(originalBricks[i].size()==0) 
				continue;
			chosen[depth] = i;
			if(chosen[0]==2 && chosen[1]==2 && chosen[2] ==6)
				System.out.println();
			explode(bricks[i].size()-1,i);
			rec(depth + 1, exploded+cleanUp());
		}
	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void explode(int row, int col) {
		if(row<0)
			return;
		
		int brick = bricks[col].get(row);
		bricks[col].set(row, 0);

		for (int i = 1; i < brick; i++) {
			for (int d = 0; d < 4; d++) {
				int newR = row + dr[d] * i;
				int newC = row + dc[d] * i;

				if (newR < 0 || newC < 0 || newC >= W || newR >= bricks[newC].size() || bricks[newC].get(newR)<=0)
					continue;

				explode(newR, newC);
			}
		}
	}

	public static int cleanUp() {
		int exploded =0;
		for (int c = 0; c < W; c++) {
			for (int r = bricks[c].size() - 1; r >= 0; r--) {
				if (bricks[c].get(r) <= 0) {
					bricks[c].remove(r);
					exploded++;
				}
			}
		}
		return exploded;
	}

	public static int nextInt() throws IOException {
		if (st == null || !st.hasMoreElements())
			st = new StringTokenizer(br.readLine());
		return Integer.parseInt(st.nextToken());
	}
}