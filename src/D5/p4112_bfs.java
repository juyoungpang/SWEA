package D5;


import java.util.*;
import java.io.FileInputStream;

public class p4112_bfs
{
    static List<Integer> list = new ArrayList<>();
    static LIN start;
    static LIN dest;
    static int[] dL = {1,1,0,0}; //왼대, 오대, 왼, 오
    static int[] dI = {0,1,-1,1}; //왼대, 오대, 왼, 오

    public static void main(String args[]) throws Exception
    {
        //System.setIn(new FileInputStream(&quot;res/input.txt&quot;));

        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        list.add(1);
        dp();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int a = sc.nextInt();
            int b = sc.nextInt();

            start = makeLIN(a<b?a:b);
            dest = makeLIN(a>=b?a:b);

            System.out.printf("#%d %d\n", test_case, bfs());
        }
    }

    public static LIN makeLIN(int num) {
        int level = 0;
        while(list.get(level)<=num) level++;
        level--;
        int index = num-list.get(level);
        return new LIN(level,index,num);
    }

    public static int bfs() {
        Set<Integer> visited = new HashSet<>();
        Queue<LINcount> queue = new LinkedList<>();

        queue.offer(new LINcount(start,0));
        visited.add(start.num);

        int answer = 0;

        while(!queue.isEmpty()) {
            LINcount cur = queue.poll();
            int curL = cur.lin.level;
            int curI = cur.lin.index;

            if(curL==dest.level && curI== dest.index) {
                answer = cur.count;
                break;
            }

            for(int i=0;i<4;i++) {
                int newL = curL+dL[i];
                int newI = curI+dI[i];

                if(!check(newL, newI)) continue;
                if(visited.contains(list.get(newL)+newI)) continue;

                queue.offer(new LINcount(new LIN(newL, newI, list.get(newL)+newI), cur.count+1));
                visited.add(list.get(newL)+newI);
            }
        }

        return answer;
    }

    public static boolean check(int level, int index) {
        if(index<0) return false;
        if(level>list.size()) return false;

        int num = list.get(level)+index;
        if(num>10000) return false;

        if(num==list.get(level+1)) return false;

        return true;
    }

    public static void dp() {
        while(list.get(list.size()-1)<10000) {
            list.add(list.get(list.size()-1)+list.size());
        }
    }
}

class LINcount{
    LIN lin;
    int count;

    public LINcount(LIN l, int c) {
        lin=l;
        count=c;
    }
}

class LIN {
    int level;
    int index;
    int num;

    public LIN(int l, int i, int n) {
        level=l;
        index=i;
        num=n;
    }
}