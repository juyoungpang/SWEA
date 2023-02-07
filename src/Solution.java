import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static int[] boxes;
	static int dumps;
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for(int TC=1;TC<=10;TC++) {
			boxes = new int[100];
			
			dumps = Integer.parseInt(br.readLine());
			StringTokenizer tok = new StringTokenizer(br.readLine());
			for(int i=0;i<100;i++) {
				boxes[i] = Integer.parseInt(tok.nextToken());
			}
			
			for(int d=0;d<dumps;d++) {
				Arrays.sort(boxes);
				boxes[0]++;
				boxes[99]--;
			}
			
			Arrays.sort(boxes);
			sb.append("#").append(TC).append(" ").append(boxes[99]-boxes[0]).append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
	public static void rec(int count) {
		Arrays.sort(boxes);

		if(count==dumps) {
			return;
		}
		
		boxes[0]++;
		boxes[99]--;
	}
}