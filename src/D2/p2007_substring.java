package D2;

import java.util.Scanner;

public class p2007_substring {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			String str = sc.next();
			
			for(int i=1;i<=10;i++) {
				if(str.substring(0,i).equals(str.substring(i,i+i))) {
					System.out.printf("#%d %d%n", test_case, i);
					break;
				}	
			}

		}
	}
}