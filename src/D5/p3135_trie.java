package D5;

import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.function.Function;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.*;

public class p3135_trie {

    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        UserSolution dictManager = new UserSolution();

        for (int TestCase = in.nextInt(), tc = 1; tc <= TestCase; tc = tc + 1) {

            int Query_N = in.nextInt();

            out.print("#" + tc);

            dictManager.init();

            for (int i = 1; i <= Query_N; i++) {
                int type = in.nextInt();

                if (type == 1) {
                    String buf = in.next();
                    dictManager.insert(buf.length(), buf);
                }
                else {
                    String buf = in.next();
                    int answer = dictManager.query(buf.length(), buf);
                    out.print(" " + answer);
                }
            }
            out.println("");
        }
        out.close();
    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                }
                catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

    }
}

class UserSolution {
    Node_3135 rootNode;
    public void init() {
        rootNode = new Node_3135();
    }

    public void insert(int buffer_size, String buf) {
        Node_3135 node = this.rootNode;
        for(int i=0;i<buffer_size;i++) {
            node = node.childNodes.computeIfAbsent(buf.charAt(i), key->new Node_3135());
            node.numEOW++;
        }
        node.endOfWord = true;
    }

    public int query(int buffer_size, String buf) {
        Node_3135 node = this.rootNode;

        for(int i=0; i<buffer_size; i++) {
            node = node.childNodes.getOrDefault(buf.charAt(i), null);
            if(node == null) {
                return 0;
            }
        }

        return node.numEOW;
    }
}

class Node_3135 {
    Map<Character, Node_3135> childNodes = new HashMap<>();
    int numEOW = 0;
    boolean endOfWord;
}