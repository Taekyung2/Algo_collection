package boj_algorithm._11000번대._11000;

import java.util.Scanner;

public class _11048_이동하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), M = sc.nextInt();
        int[][] map = new int[N + 1][M + 1];
        for(int i = 1; i <= N; i++)
            for(int j = 1; j <= M; j++)
                map[i][j] = sc.nextInt();
        for(int i = 1; i <= N; i++)
            for(int j = 1; j <= M; j++)
                map[i][j] += Math.max(map[i][j - 1], map[i - 1][j]);
        System.out.println(map[N][M]);
    }
}