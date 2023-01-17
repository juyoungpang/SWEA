import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1961_rotate {
	
	static int N;
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			System.out.printf("#%d%n", test_case);
			
			N = Integer.parseInt(br.readLine());
			int[][][] arr = new int[4][N][N];
			for(int i=0;i<N;i++) {
				StringTokenizer tok = new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					arr[0][i][j] = Integer.parseInt(tok.nextToken());
				}
			}
			
			for(int i=1;i<4;i++) {
				arr[i] = rotate90(arr[i-1]);
			}
			
			for(int i=0;i<N;i++) {
				for(int k=1;k<4;k++) {
					for(int j=0;j<N;j++) {
						System.out.print(arr[k][i][j]);
					}
					System.out.print(" ");
				}
				System.out.println();
			}
				
		}
	}
	
	public static int[][] rotate90(int[][] arr) {
		int[][] ret = new int[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				ret[i][j] = arr[N-j-1][i];
			}
		}
		return ret;
	}
}