package boj;

import java.util.Arrays;
import java.util.Scanner;

public class Q11057 {
    static final int MOD = 10007;
    static int N;
    static int[][] cache;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        cache = new int[N + 1][10];
        for(int i = 0; i <= N; i++)
            Arrays.fill(cache[i], -1);
        int sum = 0;
        for(int i = 0; i < 10; i++) {
            sum += dp(N, i);
            sum %= MOD;
        }
        System.out.println(sum);
    }

    public static int dp(int n, int prev) {
        if(n == 1)
            return 1;
        int ret = cache[n][prev];
        if(ret != -1)
            return ret;
        ret = 0;
        for(int i = 0; i <= prev; i++) {
            ret += dp(n - 1, i);
            ret %= MOD;
        }
        return cache[n][prev] = ret;
    }
}

/**
 * dp[n][prev] = (dp[n - 1][prev보다 작거나 같은거] ... + )
 */