package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.StringTokenizer;

public class p1493_impl {
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer tok = new StringTokenizer(br.readLine());
			int answer = findVal(
					findPoint(Integer.parseInt(tok.nextToken())).add(findPoint(Integer.parseInt(tok.nextToken()))));
			System.out.printf("#%d %d%n", test_case, answer);
		}
	}

	public static Point findPoint(int p) {
		int r = 1;
		int c = 1;

		int val = 1;
		while (val <= p) {
			val += r;
			r++;
		}
		r--;
		val -= r;

		while (val != p) {
			c++;
			r--;
			val++;
		}

		return new Point(r, c);
	}

	public static int findVal(Point p) {
		int r = 1;
		int c = 1;

		int val = 1;

		while (r <= p.r) {
			val += r;
			r++;
		}
		r--;
		val -= r;

		while (c <= p.c) {
			val += (r + c);
			c++;
		}
		c--;
		val -= (r + c);

		return val;
	}

}

class Point {
	int r;
	int c;

	public Point(int r, int c) {
		this.r = r;
		this.c = c;
	}

	public Point add(Point p) {
		return new Point(this.r + p.r, this.c + p.c);
	}
}