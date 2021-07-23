package boj;

import java.util.Arrays;
import java.util.Scanner;

public class Q1904 {
    static int[] cache;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        cache = new int[N + 1];
        Arrays.fill(cache, -1);
        System.out.println(dp(N));
    }

    public static int dp(int len) {
        if(len == 1) return 1;
        if(len == 2) return 2;

        int ret = cache[len];
        if(ret != -1)
            return ret;

        ret = (dp(len - 1) + dp(len - 2)) % 15746;
        return cache[len] = ret;
    }
}
