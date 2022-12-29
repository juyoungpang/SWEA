package D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
* 뒤에서부터 보는것이 중요했던 문제
* 뺐다 더하는 것이 아닌 차만 더하면 된다 --> iteration 횟수를 줄이기
* */
public class p1859_greedy {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int t=1;t<=T;t++) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            StringTokenizer tok = new StringTokenizer(br.readLine());
            for(int n=0;n<N;n++) {
                arr[n] = Integer.parseInt(tok.nextToken());
            }

            int maxVal = arr[N-1];
            long ans = 0;
            for(int i=N-2;i>=0;i--) {
                if(maxVal>arr[i]) {
                    ans+=maxVal-arr[i];
                } else {
                    maxVal = arr[i];
                }
            }

            System.out.println("#"+t+" "+ans);
        }
    }

}
