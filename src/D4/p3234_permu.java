package D4;

import java.util.Scanner;
import java.io.FileInputStream;

class p3234_permu
{

    static int answer;

    public static void main(String args[]) throws Exception
    {

        //System.setIn(new FileInputStream("res/input.txt"));

        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            answer = 0;
            int N = sc.nextInt();
            int[] arr = new int[N];
            for(int i=0;i<N;i++) {
                arr[i] = sc.nextInt();
            }

            permu(arr,0,0,new boolean[N],0);

            System.out.printf("#%d %d\n", test_case, answer);
        }
    }

    public static void permu(int[] arr, int left, int right, boolean[] visited, int depth) {
        if(depth == arr.length) {
            answer++;
            return;
        }

        for(int i = 0; i < arr.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                if(left>=right+arr[i]) {
                    permu(arr,left,right+arr[i],visited,depth+1);
                }
                permu(arr, left+arr[i], right, visited, depth+1);
                visited[i] = false;
            }
        }
    }
}