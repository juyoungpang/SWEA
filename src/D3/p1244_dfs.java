package D3;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class p1244_dfs {
	static Map<String, boolean[]> map = new HashMap<>();
	static char[] cards, answer;
	static int numR;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tok;
		StringBuilder sb = new StringBuilder();

		int TTC = Integer.parseInt(br.readLine());
		for (int TC = 1; TC <= TTC; TC++) {
			sb.append("#").append(TC).append(" ");

			tok = new StringTokenizer(br.readLine());
			String temp = tok.nextToken();
			cards = new char[temp.length()];
			answer = new char[cards.length];
			for (int i = 0; i < temp.length(); i++) {
				cards[i] = temp.charAt(i);
			}
			
			numR = Integer.parseInt(tok.nextToken());

			dfs(0);
						
			if(answer[0]==0) {
				answer = cards;
			}
			
			for (int c : answer)
				sb.append(c-'0');
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	
	public static void dfs(int depth) {
		if(depth==numR) {
			for(int i=0;i<cards.length;i++) {
				if(cards[i]>answer[i]) {
					answer = cards.clone();
					break;
				} else if (cards[i]<answer[i]) {
					break;
				}
			}
			return;
		}
		
		if(map.containsKey(String.valueOf(cards))) {
			if(map.get(String.valueOf(cards))[depth]) {
				return;
			} else {
				boolean[] b = map.get(String.valueOf(cards));
				b[depth] = true;
				map.put(String.valueOf(cards), b);
			}
		} else {
			boolean[] b = new boolean[11];
			b[depth] = true;
			map.put(String.valueOf(cards), b);
		}
		
		for(int i=0;i<cards.length-1;i++) {
			for(int j=i+1;j<cards.length;j++) {
				swap(i,j);
				dfs(depth+1);
				swap(i,j);
			}
		}
	}
	
	public static void swap (int i, int j) {
		char temp = cards[i];
		cards[i] = cards[j];
		cards[j] = temp;
	}
}