package D2;

import java.util.Scanner;
import java.io.FileInputStream;

class p1959_brute
{
    public static void main(String args[]) throws Exception
    {
		//System.setIn(new FileInputStream("res/input.txt"));

		Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int N = sc.nextInt();
            int M = sc.nextInt();

            int[] A = new int[N];
            int[] B = new int[M];

            for(int i=0;i<N;i++) {
                A[i] = sc.nextInt();
            }

            for(int i=0;i<M;i++) {
                B[i] = sc.nextInt();
            }

            int max = Integer.MIN_VALUE;

            for(int i=0;i<=Math.abs(N-M);i++) {
                int temp = 0;
                if(N<M) {
                    for(int n=0;n<N;n++) {
                        temp+=A[n]*B[n+i];
                    }
                } else {
                    for(int m=0;m<M;m++) {
                        temp+=A[m+i]*B[m];
                    }
                }

                max = Math.max(max,temp);
            }

            System.out.printf("#%d %d\n",test_case, max);
        }
    }
}