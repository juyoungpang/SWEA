package D2;

import java.util.Arrays;
import java.util.Scanner;
import java.io.FileInputStream;


class p1974_brute
{
    public static void main(String args[]) throws Exception
    {

        //System.setIn(new FileInputStream("res/input.txt"));

		Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int[][] board = new int[9][9];
            for(int i=0;i<9;i++) {
                for(int j=0;j<9;j++) {
                    board[i][j] = sc.nextInt();
                }
            }

            boolean result = true;

            for(int t=0;t<3;t++) {
                boolean[] check = new boolean[10];

                if(t==0) { //horizontal
                    for(int i=0;i<9;i++) {
                        Arrays.fill(check,false);
                        for(int j=0;j<9;j++) {
                            if(check[board[i][j]]) {
                                result = false;
                            }
                            check[board[i][j]] = true;
                        }
                    }
                } else if(t==1) { //vertical
                    for(int i=0;i<9;i++) {
                        Arrays.fill(check,false);
                        for(int j=0;j<9;j++) {
                            if(check[board[j][i]]) {
                                result = false;
                            }
                            check[board[j][i]] = true;
                        }
                    }
                } else { //box
                    for(int r=0;r<9;r+=3) {
                        for(int c=0;c<9;c+=3) {
                            Arrays.fill(check, false);
                            for(int i=0;i<3;i++) {
                                for(int j=0;j<3;j++) {
                                    if(check[board[i+r][j+c]]) {
                                        result = false;
                                    }
                                    check[board[i+r][j+c]] = true;
                                }
                            }
                        }
                    }

                    if(!result) break;
                }

            }

            System.out.printf("#%d %d\n",test_case, result?1:0);
        }
    }
}