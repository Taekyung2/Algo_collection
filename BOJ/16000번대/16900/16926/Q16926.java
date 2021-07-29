package boj;

import java.util.Scanner;

public class Q16926 {
    static int[][] map;
    static int N, M, R, iter;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        R = sc.nextInt();
        map = new int[N][M];
        iter = Math.min(N, M) / 2;

        for(int i = 0; i < N; i++)
            for(int j = 0; j < M; j++)
                map[i][j] = sc.nextInt();

        while(R-- > 0)
            rotate();

        for(int[] y : map) {
            for(int x : y)
                System.out.print(x + " ");
            System.out.println();
        }
    }

    public static void rotate() {
        for(int r = 0; r < iter; r++) {
            int tmp = map[r][r];
            for(int i = r; i < M - r - 1; i++)
                map[r][i] = map[r][i + 1];
            for(int i = r; i < N - r - 1; i++)
                map[i][M - r - 1] = map[i + 1][M - r - 1];
            for(int i = M - r - 1; i > r; i--)
                map[N - r - 1][i] = map[N - r - 1][i - 1];
            for(int i = N - r - 1; i > r + 1; i--)
                map[i][r] = map[i - 1][r];
            map[r + 1][r] = tmp;
        }
    }
}
