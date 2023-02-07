import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException{
		int[] boxes = null;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for(int TC=1;TC<=10;TC++) {
			boxes = new int[100];
			
			int dumps = Integer.parseInt(br.readLine());
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
			sb.append("#").append(TC).append(boxes[99]-boxes[0]).append("\n");
		}
		
		System.out.println(sb.toString());
	}
}