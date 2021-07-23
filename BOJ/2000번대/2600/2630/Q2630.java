package boj;

import java.util.Scanner;

public class Q2630 {
    static int[][] board;
    static int[] ret = new int[2];

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        board = new int[N][N];
        for(int i = 0; i < N; i++)
            for(int j = 0; j < N; j++)
                board[i][j] = sc.nextInt();

        divide(0, 0, N);
        System.out.println(ret[0]);
        System.out.println(ret[1]);
    }

    public static void divide(int y, int x, int len) {
        if (!allSame(y, x, len)) {
            len /= 2;
            divide(y, x, len);
            divide(y + len, x, len);
            divide(y, x + len, len);
            divide(y + len, x + len, len);
        } else {
            ret[board[y][x]]++;
        }
    }

    public static boolean allSame(int y, int x, int len) {
        int cur = board[y][x];
        for(int i = y; i < y + len; i++)
            for(int j = x; j < x + len; j++)
                if(cur != board[i][j])
                    return false;
        return true;
    }
}
