package boj;

import java.util.Arrays;
import java.util.Scanner;

public class Q1932 {
    static int N;
    static int[][] triangle, cache;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        triangle = new int[N][N];
        cache = new int[N][N];
        for(int i = 0; i < N; i++)
            Arrays.fill(cache[i], -1);

        for(int i = 0; i < N; i++)
            for(int j = 0; j <= i; j++)
                triangle[i][j] = sc.nextInt();
        System.out.println(getMax(0, 0));
    }

    public static int getMax(int y, int x) {
        if(y == N) return 0;
        int ret = cache[y][x];
        if(ret != -1) return ret;
        ret = triangle[y][x] + Math.max(getMax(y + 1, x), getMax(y + 1, x + 1));
        return cache[y][x] = ret;
    }
}
