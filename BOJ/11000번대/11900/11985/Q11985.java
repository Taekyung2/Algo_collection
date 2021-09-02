package boj;

import java.io.*;
import java.util.*;

public class Q11985 {
    static long[] cache;
    static int[] orange;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int K = sc.nextInt();
        cache = new long[N + 1];
        orange = new int[N + 1];

        for(int i = 1; i <= N; i++)
            orange[i] = sc.nextInt();

        Arrays.fill(cache, Long.MAX_VALUE);
        cache[0] = 0;

        for(int i = 1; i <= N; i++) {
            int max = 0;
            int min = Integer.MAX_VALUE;
            for(int j = 1; j <= M; j++) {
                if(i < j) break;
                max = Math.max(max, orange[i - j + 1]);
                min = Math.min(min, orange[i - j + 1]);
                cache[i] = Math.min(cache[i], cache[i - j] + K + (long) j * (max - min));
            }
        }

        System.out.println(cache[N]);
    }
}

/**
 *  cache[N] = N개의 오렌지를 포장하는데 필요한 최소 비용
 *  cache[N] = cache[N - i] + 오렌지 i개 포장 비용
 */