package etc;

import java.util.*;

public class DXWinter_q1
{
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};

    static char[][] map;
    static Set<Character> bought;
    static boolean[][] visited;

    static int max;

    public static void main(String args[]) throws Exception
    {
        //System.setIn(new FileInputStream("res/input.txt"));

        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int r = sc.nextInt();
            int c = sc.nextInt();

            map = new char[r][c];
            bought = new HashSet<>();
            visited = new boolean[r][c];

            for(int i=0;i<r;i++) {
                String temp = sc.next();
                for(int j=0;j<c;j++) {
                    map[i][j] = temp.charAt(j);
                }
            }

            bought.add(map[0][0]);
            visited[0][0] = true;
            max = Integer.MIN_VALUE;

            permu(0,0,1);

            System.out.printf("#%d %d\n", test_case, max);
        }
    }

    public static void permu(int row, int col, int depth) {
        max = Math.max(max, depth);

        for(int i=0;i<4;i++) {
            int newR = row+dr[i];
            int newC = col+dc[i];

            if(newR<0 || newC<0 || newR>=map.length || newC>=map[0].length
                    || visited[newR][newC] || bought.contains(map[newR][newC])) continue;

            visited[newR][newC] = true;
            bought.add(map[newR][newC]);
            permu(newR, newC, depth+1);
            visited[newR][newC] = false;
            bought.remove(map[newR][newC]);
        }
    }
}