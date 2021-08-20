package boj;

import java.util.Arrays;
import java.util.Scanner;

public class Q10844 {
    static int N;
    static int[][] cache;
    static int MOD = 1000000000;

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
            return (prev == 0) ? 0 : 1;
        int ret = cache[n][prev];
        if(ret != -1)
            return ret;
        ret = 0;
        if(prev == 0) {
            ret += dp(n - 1, prev + 1) % MOD;
        } else if(prev == 9) {
            ret += dp(n - 1, prev -1) % MOD;
        } else
            ret += (dp(n - 1, prev - 1) + dp(n - 1, prev + 1)) % MOD;
        return cache[n][prev] = ret;
    }
}

/**
 *  f(1) = 길이 1인 계단수
 *  f(2) = f(1) + 뒤로 더하기, 뒤가 9면 1개만 더하기, 뒤가 0이면 1개만 더하기-> 1(12), 2(23), 3(34), 4, 5, 6, 7, 8, 9
 *  f(3) = f(2) + 뒤로 더하기
 */
