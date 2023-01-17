import java.util.Scanner;

public class p1940_iteration {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();

			int curSpeed = 0;
			int distance = 0;

			for (int n = 0; n < N; n++) {
				int cmd = sc.nextInt();
				int amnt = 0;
				if(cmd!=0) amnt = sc.nextInt();

				if (cmd == 1) { // 가속
					curSpeed += amnt;
				} else {
					if(curSpeed<amnt) curSpeed=0;
					else curSpeed -= amnt;
				}
				
				distance += curSpeed;
			}

			System.out.printf("#%d %d%n", test_case, distance);
		}
	}
}