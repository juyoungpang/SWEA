import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.io.FileInputStream;

class Solution
{
    public static void main(String args[]) throws IOException
    {
        //System.setIn(new FileInputStream("res/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T;
        T=Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= T; test_case++)
        {
            System.out.print("#"+test_case+" ");

            StringTokenizer tok = new StringTokenizer(br.readLine());

            String N = tok.nextToken();
            int x = Integer.parseInt(tok.nextToken());
            int y = Integer.parseInt(tok.nextToken());

            if(N.length()<2) {
                if(x!=0) {
                    System.out.println(-1);
                } else {
                    System.out.println(Integer.parseInt(N)<y?-1:y);
                }
            } else if(N.length()<3){
                int n1 = x*10+y;
                int n2 = y*10+x;

                if(Integer.parseInt(N)<n1) {
                    System.out.println(-1);
                } else if(Integer.parseInt(N)<n2) {
                    System.out.println(n1);
                } else {
                    System.out.println(n2);
                }
            } else {
                StringBuilder sb = new StringBuilder();
                boolean left = false;
                boolean inNeed = false;
                for(int i=0;i<N.length();i++) {
                    if(inNeed) {
                        if(i<0 || (i==0 && Integer.parseInt(sb.substring(i,i+1))==x)) {
                            break;
                        } else if(Integer.parseInt(sb.substring(i,i+1))==y) {
                            sb.deleteCharAt(i);
                            sb.append(x);
                            left = true;
                            inNeed = false;
                            continue;
                        } else {
                            sb.deleteCharAt(i);
                            i-=2;
                            continue;
                        }
                    }

                    int n = Integer.parseInt(N.substring(i,i+1));
                    if(left) {
                        sb.append(y);
                    } else if(n>y) {
                        left = true;
                        sb.append(y);
                    } else if(n==y) {
                        sb.append(y);
                    } else if(n>x) {
                        left = true;
                        sb.append(x);
                    } else if(n==x) {
                        sb.append(x);
                    } else {
                        i-=2;
                        inNeed=true;
                    }
                }

                if(sb.length()==N.length()) {
                    if(x!=0 && sb.indexOf(String.valueOf(x))==-1) {
                        sb.setLength(sb.length()-1);
                        sb.append(x);
                        System.out.println(sb);
                    } else if(sb.substring(0,1).equals("0")) {
                        System.out.println(sb.substring(1));
                    } else {
                        System.out.println(sb);
                    }
                } else {
                    sb.setLength(0);
                    for(int i=0;i<N.length()-2;i++){
                        sb.append(y);
                    }
                    sb.append(x);
                    System.out.println(sb);
                }
            }
        }
    }
}