package D4;

import java.util.Scanner;

public class p1226_dfs
{
    static int dr[] = {-1,1,0,0};
    static int dc[] = {0,0,-1,1};

    static int startRow, startCol;
    static int[][] arr;
    static boolean[][] visited;

    static int answer;

    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);

        for(int t=0;t<10;t++)
        {
            int T = sc.nextInt();
            answer = 0;
            arr = new int[16][16];
            visited = new boolean[16][16];

            for(int i=0;i<16;i++) {
                String temp = sc.next();
                for(int j=0;j<16;j++){
                    arr[i][j] = Integer.parseInt(temp.substring(j,j+1));
                    if(arr[i][j]==2) {
                        startRow = i;
                        startCol = j;
                    }
                }
            }

            dfs(startRow, startCol);

            System.out.printf("#%d %d\n", T, answer);


        }
    }

    public static void dfs(int r, int c) {
        if(arr[r][c]==3) {
            answer = 1;
            return;
        }

        for(int i=0;i<4;i++) {
            int newRow = r+dr[i];
            int newCol = c+dc[i];

            if(newRow<0 || newCol<0 || newRow>=16 || newCol>=16 || visited[newRow][newCol] || arr[newRow][newCol]==1) continue;

            visited[newRow][newCol]=true;
            dfs(newRow, newCol);
        }

    }
}