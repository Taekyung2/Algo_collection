package boj;

import java.util.Scanner;

public class Q2579 {
    static int[] arr;
    static int[] cache;
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n + 1];
        cache = new int[n + 1];

        for(int i = 1; i <= n; i++)
            arr[i] = sc.nextInt();

        if(n == 1) {
            System.out.println(arr[1]);
            return;
        }

        cache[1] = arr[1];
        cache[2] = arr[1] + arr[2];
        System.out.println(dp(n));
    }

    public static int dp(int n) {
        for(int i = 3; i <= n; i++)
            cache[i] = Math.max(cache[i - 2], arr[i - 1] + cache[i - 3]) + arr[i];
        return cache[n];
    }
}
