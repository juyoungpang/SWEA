package D2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p1288_impl {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int TTC = Integer.parseInt(br.readLine());

		for (int TC = 1; TC <= TTC; TC++) {
			int num = Integer.parseInt(br.readLine());
			boolean[] checked = new boolean[10];
			int count = 0;
			int mult = 1;
			
			while(count!=10) {
				int n = num*mult++;
				while(n>0) {
					if(!checked[n%10]) {
						count++;
						checked[n%10] = true;
					}
					n/=10;
				}
			}
			
			
			sb.append("#").append(TC).append(" ").append(num*(mult-1)).append("\n");
		}
		
		System.out.println(sb.toString());
	}
}