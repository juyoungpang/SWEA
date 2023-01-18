package D3;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p7272_String {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		String numHoles[] = {"CEFGHIJKLMNSTUVWXYZ", "ADOPQR"};

		for (int test_case = 1; test_case <= T; test_case++) {
			
			StringTokenizer tok = new StringTokenizer(br.readLine());
			
			String a = tok.nextToken();
			String b = tok.nextToken();
			
			if(a.length()!=b.length()) {
				System.out.printf("#%d DIFF%n", test_case);
				continue;
			}
			boolean same = true;
			for(int i=0;i<a.length();i++) {
				String subA = a.substring(i,i+1);
				String subB = b.substring(i,i+1);
				
				int numHoleA = numHoles[0].contains(subA)?0:numHoles[1].contains(subA)?1:2;
				int numHoleB = numHoles[0].contains(subB)?0:numHoles[1].contains(subB)?1:2;
				
				if(numHoleA != numHoleB) {
                    same = false;
					break;
				}
			}
			
			System.out.printf("#%d %s%n", test_case, same?"SAME":"DIFF");
			
		}
	}
}