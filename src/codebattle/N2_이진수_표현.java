package codebattle;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N2_이진수_표현 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tok;
		StringBuilder sb = new StringBuilder();
		int TTC = Integer.parseInt(br.readLine());
		
		for(int TC=1; TC<=TTC; TC++) {
			sb.append("#").append(TC);
			tok = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(tok.nextToken());
			int M = Integer.parseInt(tok.nextToken());
			
			int lastBit = (1<<N) -1;
			if(lastBit == (lastBit&M)) {
				sb.append(" ON\n");
			} else {
				sb.append(" OFF\n");
			}
		}
		
		System.out.println(sb.toString());
		
	}
}