package D5;

import java.util.*;

public class p1248_binaryTree
{

    static Map<Integer, Node_1248> map;
    static Set<Integer> visited;
    public static void main(String args[]) throws Exception
    {
        //System.setIn(new FileInputStream(&quot;res/input.txt&quot;));
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int answer1=0;

            int V = sc.nextInt();
            int E = sc.nextInt();
            int num[] = new int[2];
            num[0]= sc.nextInt();
            num[1] = sc.nextInt();

            map = new HashMap<>();

            for(int e=0;e<E;e++) {
                int parent = sc.nextInt();
                int child = sc.nextInt();

                //부모노드
                if(!map.containsKey(parent)) {
                    map.put(parent, new Node_1248(0, child));
                } else {
                    map.get(parent).setChild(child);
                    map.put(parent, map.get(parent));
                }
                //자식노드
                if(!map.containsKey(child)) {
                    map.put(child, new Node_1248(parent, 0));
                } else {
                    map.get(child).setParent(parent);
                    map.put(child, map.get(child));
                }
            }

            //부모들 찾기
            Set<Integer> parents = new HashSet<>();
            int p = map.get(num[0]).parent;
            parents.add(p);
            while(p!=0) {
                p = map.get(p).parent;
                parents.add(p);
            }

            //동일 부모 찾기
            p=num[1];
            while(p!=0) {
                p = map.get(p).parent;
                if(parents.contains(p)) {
                    answer1 = p;
                    break;
                }
            }

            //자식 노드 갯수 찾기
            visited = new HashSet<>();
            gotoChild(answer1);

            System.out.printf("#%d %d %d\n", test_case, answer1, visited.size());
        }
    }

    public static void gotoChild(int current) {
        if(visited.contains(current)) return;

        visited.add(current);
        Node_1248 cur = map.get(current);
        if(cur.child1>0) gotoChild(cur.child1);
        if(cur.child2>0) gotoChild(cur.child2);
    }
}

class Node_1248
{
    int parent = 0;
    int child1 = 0;
    int child2 = 0;

    public Node_1248(int p, int c) {
        if(p!=0) parent = p;
        if(c!=0) child1 = c;
    }

    public void setChild(int c) {
        if(child1==0) child1 = c;
        else child2 = c;
    }

    public void setParent(int p) {
        parent = p;
    }
}
