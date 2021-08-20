package boj;

import java.util.Scanner;

public class Q11051 {
    static final int MOD = 10007;
    static int[][] cache;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        cache = new int[N + 1][K + 1];
        System.out.println(dp(N, K));
    }

    public static int dp(int n, int k) {
        if(k == 0 || n == k)
            return 1;
        int ret = cache[n][k];
        if(ret != 0)
            return ret;
        return cache[n][k] = (dp(n - 1, k - 1) + dp(n - 1, k)) % MOD;
    }
}

/**
 * dp(n, k) = dp(n - 1, k - 1) + dp(n - 1, k)
 */