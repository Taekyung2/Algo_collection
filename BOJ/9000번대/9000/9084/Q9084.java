package boj;

import java.io.*;
import java.util.*;

public class Q9084 {
    static int N, M;
    static int[] coin;
    static int[][] cache;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while(T-- > 0) {
            N = sc.nextInt();
            coin = new int[N];
            for(int i = 0; i < N; i++)
                coin[i] = sc.nextInt();
            M = sc.nextInt();
            cache = new int[N][M + 1];
            System.out.println(dp(0, M));
        }
    }

    public static int dp(int c, int val) {
        if(val == 0)
            return 1;
        if(val < 0)
            return 0;
        int ret = cache[c][val];
        if(ret != 0)
            return ret;
        ret = 0;
        for(int i = c; i < N; i++)
            ret += dp(i, val - coin[i]);
        return cache[c][val] = ret;
    }
}

/**
 * dp[n][m] = coin[n]원 이상의 동전으로 m원을 만들기
 */