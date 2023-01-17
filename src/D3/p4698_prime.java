
import java.util.Arrays;
import java.util.Scanner;

public class p4698_prime {
	
	static boolean[] primeNumbers = new boolean[1000001];
	
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		findList();

		for (int test_case = 1; test_case <= T; test_case++) {
			
			int D = sc.nextInt();
			int A = sc.nextInt();
			int B = sc.nextInt();
			
			int answer = 0;
			
			for(int i=A;i<=B;i++) {
				if(primeNumbers[i] && String.valueOf(i).contains(String.valueOf(D))) answer++;
			}

			System.out.printf("#%d %d%n", test_case, answer);
		}
	}
	
	public static void findList() {
		Arrays.fill(primeNumbers, true);
		
		primeNumbers[0] = false;
		primeNumbers[1] = false;
		
		for(int i=2;i<primeNumbers.length;i++) {
			if(primeNumbers[i]) {
				for(int j=2;j*i<primeNumbers.length;j++) {
					primeNumbers[i*j] = false;
				}
			}
		}
	}
}