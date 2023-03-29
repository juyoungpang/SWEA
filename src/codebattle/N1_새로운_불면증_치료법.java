package codebattle;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class N1_새로운_불면증_치료법 {
 
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
 
    public static void main(String[] args) throws IOException {
        int TTC = nextInt();
        for (int TC = 1; TC <= TTC; TC++) {
            sb.append("#").append(TC).append(" ");
 
            long N = (long) nextInt();
            long mult = 1;
            int bit = 0;
            while (bit != (1 << 10) - 1) {
                long num = N * (mult++);
                while (num != 0) {
                    int digit = (int) num % 10;
                    bit = bit | (1 << ((int) num % 10));
                    num /= 10;
                }
            }
            sb.append(N * (mult - 1)).append("\n");
        }
        System.out.println(sb.toString());
    }
 
    public static int nextInt() throws IOException {
        if (st == null || !st.hasMoreElements())
            st = new StringTokenizer(br.readLine());
        return Integer.parseInt(st.nextToken());
    }
}