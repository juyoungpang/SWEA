package D3;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p9229_combi {

	static int m, ans;
	static int[] bag;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tok;
		StringBuilder sb = new StringBuilder();

		int TTC = Integer.parseInt(br.readLine());

		for (int TC = 1; TC <= TTC; TC++) {
			tok = new StringTokenizer(br.readLine());
			bag = new int[Integer.parseInt(tok.nextToken())];
			m = Integer.parseInt(tok.nextToken());

			tok = new StringTokenizer(br.readLine());
			for (int i = 0; i < bag.length; i++) {
				bag[i] = Integer.parseInt(tok.nextToken());
			}

			ans = -1;
			combi(0, 0, 0);
			sb.append("#").append(TC).append(" ").append(ans).append("\n");
		}

		System.out.println(sb.toString());
	}

	public static void combi(int k, int idx, int w) {
		if (k == 2) {
			ans = Math.max(ans, w);
			return;
		}

		if (idx == bag.length) {
			return;
		}

		combi(k, idx + 1, w);
		if (w + bag[idx] <= m)
			combi(k + 1, idx + 1, w + bag[idx]);
	}
}