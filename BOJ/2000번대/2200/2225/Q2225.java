package boj;

import java.util.Scanner;

public class Q2225 {
    static final int MOD = 1_000_000_000;
    static int N, K;
    static int[][] cache;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        cache = new int[N + 1][K + 1];
        System.out.println(dp(N, K));
    }

    public static int dp(int n, int k) {
        if(n == 0)
            return 1;
        if(k == 0)
            return 0;
        if(cache[n][k] != 0)
            return cache[n][k];
        return cache[n][k] = (dp(n - 1, k) + dp(n, k - 1)) % MOD;
    }
}

/**
 *  # 계획
 *  1. 0부터 N까지의 정수 K개를 더해서 그 합이 N이 되는 경우의 수 구하기
 *      - N = 20, K = 2인 경우
 *          - (20 + 0), (19 + 1), (18 + 2), .... , (0 + 20) -> 21가지
 *  2. cache[n][k] = cache[n - 1][k] + cache[n][k - 1]
 */
