package boj;

/**
 * 1 <= n <= 100,000
 * dp(a) = a에서 시작하는 가장 큰 연속합
 * dp(cur) = max(dp(cur), arr[cur] + dp(cur + 1))
 */

import java.util.Arrays;
import java.util.Scanner;

public class Q1912 {
    static int n;
    static int[] arr, cache;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n];
        cache = new int[n];
        Arrays.fill(cache, -1);
        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        dp(0);
        System.out.println(Arrays.stream(cache).max().getAsInt());
    }

    public static int dp(int cur) {
        if(cur == n)
            return -1;

        int ret = cache[cur];
        if(ret != -1)
            return ret;

        ret = Math.max(arr[cur], arr[cur] + dp(cur + 1));

        return cache[cur] = ret;
    }
}
