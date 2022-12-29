package D2;

import java.util.Scanner;
import java.io.FileInputStream;

class p1204_brute
{
    public static void main(String args[]) throws Exception
    {
		Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int nothing = sc.nextInt();

            int maxValue = -1;
            int maxIndex = -1;
            int[] count = new int[101];

            for(int i=0;i<1000;i++) {
                int value = sc.nextInt();
                count[value]++;
                if(count[value]>maxValue || (count[value]==maxValue && value>maxIndex)) {
                    maxValue = count[value];
                    maxIndex = value;
                }
            }

            System.out.printf("#%d %d\n",test_case, maxIndex);
        }
    }
}