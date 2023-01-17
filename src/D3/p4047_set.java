import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class p4047_set {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			Set<Integer>[] set = new Set[4];
			for(int i=0;i<4;i++) {
				set[i] = new HashSet<>();
			}
			
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(test_case).append(" ");
			
			String str = br.readLine();
			boolean isError = false;
			for(int i=0;i<str.length();i+=3) {
				int type = 4;
				switch (str.charAt(i)) {
				case 'S':
					type=0;
					break;
				case 'D':
					type=1;
					break;
				case 'H':
					type=2;
					break;
				case 'C':
					type=3;
					break;
				}
				
				int num = Integer.parseInt(str.substring(i+1,i+3));
				if(set[type].contains(num)) {
					sb.append("ERROR");
					isError = true;
					break;
				} 
				set[type].add(num);
			}
			
			if(isError) {
				System.out.println(sb);
				continue;
			}
			
			for(Set<Integer> s:set) {
				sb.append(13-s.size()).append(" ");
			}
			
			System.out.println(sb);
		}
	}
}