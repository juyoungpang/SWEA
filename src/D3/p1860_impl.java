package D3;
import java.util.List;
import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class p1860_impl {
	public static void main(String args[]) throws Exception {
//		System.setIn(new FileInputStream("res/input.txt"));		
//		List<String> allLines = Files.readAllLines(Paths.get("res/output.txt"));
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			boolean possible = true;
			
			int N = sc.nextInt();
			int M = sc.nextInt();
			int K = sc.nextInt();
			
			String input = String.format("%d %d %d --> ", N, M, K);
			
			int[] breads = new int[11112];
			int lastCustomer = 0;
			
			for(int i = 0; i<N;i++) {
				int time = sc.nextInt();
				input+=time+" ";
				breads[time]--;
				lastCustomer = Math.max(lastCustomer, time);
			}
			
			for(int i=1;i<=lastCustomer+1;i++) {
				if(breads[i-1]<0) {
					possible = false;
					break;
				}
				
				if(i==lastCustomer+1) break;
				
				breads[i] += breads[i-1];
				if(i%M==0) breads[i]+=K;
			}
			
//			if(!allLines.get(test_case-1).equals(String.format("#%d %s", test_case, possible?"Possible":"Impossible"))) {
//				System.out.println("WRONG #"+test_case+" : "+input);
//			}

			System.out.printf("#%d %s%n", test_case, possible?"Possible":"Impossible");
		}
	}
}