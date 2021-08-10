package boj;

import java.util.Scanner;

public class Q11053 {
    static int N;
    static int[] arr, cache;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        cache = new int[N];
        arr = new int[N];
        for(int i = 0; i < N; i++)
            arr[i] = sc.nextInt();

        int ret = 0;
        for(int i = 0; i < N; i++)
            ret = Math.max(ret, dp(i));
        System.out.println(ret);
    }

    public static int dp(int n) {
        int ret = cache[n];
        if(ret != 0)
            return ret;
        ret = 1;
        for(int i = n + 1; i < N; i++) {
            if(arr[n] < arr[i])
                ret = Math.max(ret, dp(i) + 1);
        }
        return cache[n] = ret;
    }
}
