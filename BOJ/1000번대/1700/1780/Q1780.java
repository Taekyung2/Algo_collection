package boj;

import java.util.Scanner;

public class Q1780 {
    static int N;
    static int[][] map;
    static int[] ret = new int[3];

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new int[N][N];
        for(int i = 0; i < N; i++)
            for(int j = 0; j < N; j++)
                map[i][j] = sc.nextInt();

        divide(0, 0, N);
        for(int i = 0; i < 3; i++)
            System.out.println(ret[i]);
    }

    public static void divide(int y, int x, int len) {
        if(!isSame(y, x, len)) {
            len /= 3;
            for(int i = 0; i < 3; i++)
                for(int j = 0; j < 3; j++)
                    divide(y + (i * len), x + (j * len), len);
        } else {
            ret[map[y][x] + 1]++;
        }
    }

    public static boolean isSame(int y, int x, int len) {
        for(int i = y; i < y + len; i++)
            for(int j = x; j < x + len; j++)
                if(map[i][j] != map[y][x])
                    return false;
        return true;
    }
}
