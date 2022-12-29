package D4;

import java.util.PriorityQueue;
import java.util.Scanner;
import java.io.FileInputStream;

class p1249_bfs
{
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static int answer;
    static int[][] map;
    static boolean[][] visited;

    public static void main(String args[]) throws Exception
    {
		//System.setIn(new FileInputStream("res/input.txt"));

		Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++)
        {
            answer = Integer.MAX_VALUE;
            int N = sc.nextInt();
            map = new int[N][N];
            visited = new boolean[N][N];
            for(int i=0;i<N;i++) {
                String st = sc.next();
                for(int j=0;j<N;j++) {
                    map[i][j] = Integer.parseInt(st.substring(j,j+1));
                }
            }

            bfs();

            System.out.printf("#%d %d\n", test_case, answer);

        }
    }

    public static void bfs() {
        PriorityQueue<Pos> queue = new PriorityQueue<>();

        queue.add(new Pos(0,0,0));
        visited[0][0] = true;

        while(!queue.isEmpty()) {
            Pos p = queue.poll();
            int r = p.r;
            int c = p.c;
            int cost = p.cost;

            if (r == visited.length - 1 && c == visited.length - 1) {
                answer = Math.min(answer, cost);
            }

            for (int i = 0; i < 4; i++) {
                int newR = r + dr[i];
                int newC = c + dc[i];

                if (isValid(newR, newC, visited.length) && !visited[newR][newC]) {
                    queue.add(new Pos(newR, newC, cost+map[newR][newC]));
                    visited[newR][newC] = true;
                }
            }
        }
    }

    public static boolean isValid(int r, int c, int N) {
        return r>=0 && c>=0 && r<N && c<N;
    }
}

class Pos implements Comparable<Pos> {
    int r;
    int c;
    int cost;

    public Pos(int r, int c, int cost) {
        this.r = r;
        this.c = c;
        this.cost = cost;
    }

    @Override
    public int compareTo(Pos o) {
        return this.cost - o.cost;
    }
}