package boj;

import java.util.Scanner;

public class Q2193 {
    static long[] cache;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        cache = new long[N + 1];
        cache[1] = 1;

        for(int i = 2; i <= N; i++)
            cache[i] = cache[i - 2] + cache[i - 1];
        System.out.println(cache[N]);
    }
}
