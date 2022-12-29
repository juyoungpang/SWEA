package D2;

import java.util.Scanner;
import java.io.FileInputStream;

class p1209_2Darr
{
    public static void main(String args[]) throws Exception
    {
        //System.setIn(new FileInputStream("res/input.txt"));

        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        int[][] arr = new int[100][100];

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int max = Integer.MIN_VALUE;

            //input받으면서 horizontal처리
            for(int i=0;i<100;i++) {
                int temp = 0;
                for(int j=0;j<100;j++) {
                    arr[i][j] = sc.nextInt();
                    temp+=arr[i][j];
                }
                max = Math.max(max,temp);
            }

            for(int i=0;i<100;i++) {
                int tempV = 0;
                int tempD1 = 0;
                int tempD2 = 0;
                for(int j=0;j<100;j++) {
                    tempV+=arr[j][i];
                    tempD1+=arr[j][j];
                    tempD2+=arr[j][100-j-1];
                }
                max = Math.max(Math.max(Math.max(max,tempV),tempD1),tempD2);
            }

            System.out.printf("#%d %d\n",test_case, max);

            if(sc.hasNext()) T = sc.nextInt();
        }
    }
}