package boj;

import java.util.Scanner;

public class Q1992 {
    static int N;
    static char[][] map;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new char[N][N];

        for(int i = 0; i < N; i++)
            map[i]= sc.next().toCharArray();
        divide(0, 0, N);
        System.out.println(sb);
    }

    public static void divide(int y, int x, int len) {
        char cur = map[y][x];
        boolean chk = true;
        loop:
        for(int i = y;  i < y + len; i++) {
            for(int j = x; j < x + len; j++) {
                if(map[i][j] != cur) {
                    chk = false;
                    break loop;
                }
            }
        }
        if(chk)
            sb.append(cur);
        else {
            len /= 2;
            sb.append("(");
            divide(y, x, len);
            divide(y, x + len, len);
            divide(y + len, x, len);
            divide(y + len, x + len, len);
            sb.append(")");
        }
    }
}
