package D5;

import java.util.*;

public class p1247_permu
{

    static int answer;
    static Pos[] customers;
    static Pos company;
    static Pos home;

    public static void main(String args[]) throws Exception
    {
        //System.setIn(new FileInputStream(&quot;res/input.txt&quot;));

        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        for(int test_case = 1; test_case <= T; test_case++)
        {
            int num = sc.nextInt();
            answer = Integer.MAX_VALUE;

            company = new Pos(sc.nextInt(), sc.nextInt());
            home = new Pos(sc.nextInt(), sc.nextInt());

            customers = new Pos[num];
            for(int i=0;i<customers.length;i++) {
                customers[i] = new Pos(sc.nextInt(), sc.nextInt());
            }

            permu(new int[num], new boolean[num], 0);

            System.out.printf("#%d %d\n", test_case, answer);

        }
    }

    public static void permu(int[] selected, boolean[] visited, int depth){
        if(depth==selected.length) {
            int totalDistance = findDistance(company, customers[selected[0]]);
            for(int i=0;i<selected.length-1;i++) {
                totalDistance += findDistance(customers[selected[i]], customers[selected[i+1]]);
                if(totalDistance>answer) return;
            }
            totalDistance += findDistance(customers[selected[selected.length-1]], home);

            answer = Math.min(answer, totalDistance);
            return;
        }

        for(int i=0;i<selected.length;i++) {
            if(visited[i]) continue;

            visited[i] = true;
            selected[depth] = i;
            permu(selected, visited, depth+1);
            visited[i] = false;
        }
    }


    public static int findDistance(Pos a, Pos b) {
        return Math.abs(a.x-b.x)+Math.abs(a.y-b.y);
    }
}

class Pos {
    int x;
    int y;

    public Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }
}