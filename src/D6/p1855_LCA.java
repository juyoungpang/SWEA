package D6;
import java.util.*;

public class p1855_LCA
{
    /*
     * size: N+1 * 2
     * row: Node 번호
     * col: parent, level
     */
    static int[][] pl;
    static List<Integer>[] children;
    static Map<Long, Integer> cache;
    static long answer = 0;

    public static void main(String args[]) throws Exception
    {
        //System.setIn(new FileInputStream("res/input.txt"));

        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int N = sc.nextInt();
            pl = new int[N+1][2];
            pl[1][0] = 0; //root node
            pl[1][1] = 0;

            children = new List[N+1];
            children[1] = new ArrayList<>();

            cache = new HashMap<>();

            for(int i=2;i<N+1;i++) {
                int parent = sc.nextInt();
                pl[i][0] = parent;
                pl[i][1] = pl[parent][1]+1;
                children[i] = new ArrayList<>();
                children[parent].add(i);
            }

            answer = 0;

            BFS();

            System.out.printf("#%d %d\n", test_case, answer);
        }
    }

    /**
     * 노드 a와 b의 최소 공통 조상
     * @param a 노드 a 번호
     * @param b 노드 b 번호
     * @return least common parent
     */
    public static int findLCA(int a, int b) {
        while(pl[a][1]>pl[b][1]) {  //level이 다르다면 맞춘다
            a = pl[a][0];
        }
        while (pl[a][1]<pl[b][1]) {
            b = pl[b][0];
        }

        if(a==b) return a;

        long key = (a<b)?(long)a * 100000 + (long)b:(long)b * 100000 + (long)a;
        if (cache.containsKey(key)){
            return cache.get(key);
        }

        int result = findLCA(pl[a][0], pl[b][0]);

        cache.put(key, result);

        return result;
    }

    public static void BFS() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1); //root node
        int nodeBefore = 0;

        while(!queue.isEmpty()) {
            int node = queue.poll();

            for(int childNode : children[node]) {
                queue.offer(childNode);
            }

            if(nodeBefore == 1) {
                answer++;
            } else if(nodeBefore > 1) {
                int lca = findLCA(node, nodeBefore);
                answer+=(pl[nodeBefore][1] - pl[lca][1])+(pl[node][1] - pl[lca][1]);
            }

            nodeBefore = node;
        }
    }
}
