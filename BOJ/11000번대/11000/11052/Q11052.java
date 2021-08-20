package boj;

import java.util.Arrays;
import java.util.Scanner;

public class Q11052 {
    static int N;
    static int[] arr, cache;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N + 1];
        cache = new int[N + 1];
        Arrays.fill(cache, -1);
        for(int i = 1; i <= N; i++)
            arr[i] = sc.nextInt();
        System.out.println(dp(N));
    }

    public static int dp(int n) {
        if(n == 0)
            return 0;
        int ret = cache[n];
        if(ret != -1)
            return ret;
        ret = 0;
        for(int i = 1; i <= n; i++)
            ret = Math.max(ret, dp(n - i) + arr[i]);
        return cache[n] = ret;
    }
}

/**
 * dp(N) = max(dp(N - x) + map[x], cache[N])
 */