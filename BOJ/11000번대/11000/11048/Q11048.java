package boj;

import java.util.Arrays;
import java.util.Scanner;

public class Q11048 {
    static int N, M;
    static int[][] map;
    static int[][] cache;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N][M];
        cache = new int[N][M];
        for(int i = 0; i < N; i++)
            Arrays.fill(cache[i], -1);

        for(int i = 0; i < N; i++)
            for(int j = 0; j < M; j++)
                map[i][j] = sc.nextInt();
        System.out.println(dp(0, 0));
    }

    public static int dp(int r, int c) {
        if(r >= N || c >= M)
            return 0;
        if(r == N - 1 && c == M - 1)
            return map[N - 1][M - 1];
        int ret = cache[r][c];
        if(ret != -1)
            return ret;
        ret = map[r][c];
        return cache[r][c] = ret + Math.max(dp(r + 1, c), Math.max(dp(r, c + 1), dp(r + 1, c + 1)));
    }
}

/**
 * dp(r, c) = (r, c)에서 (N, M)까지 가는데 먹을 수 있는 최대 사탕 개수
 * dp(r, c) = dp(r + 1, c), dp(r, c + 1), dp(r + 1, c + 1) 중 최대
 */