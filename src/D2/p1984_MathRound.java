import java.util.Arrays;
import java.util.Scanner;

public class p1984_MathRound {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int[] arr = new int[10];
			for(int i=0;i<10;i++) {
				arr[i] = sc.nextInt();
			}
			
			Arrays.sort(arr);
			
			int answer = 0;
			for(int i=1;i<9;i++) {
				answer+=arr[i];
			}

			System.out.printf("#%d %d%n", test_case, (int)Math.round(answer/8.0));
		}
	}
}