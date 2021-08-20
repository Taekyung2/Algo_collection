package boj;

import java.util.Arrays;
import java.util.Scanner;

public class Q1495 {
    static int N, S, M;
    static int[] V;
    static int[][] cache;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        S = sc.nextInt();
        M = sc.nextInt();
        V = new int[N];
        cache = new int[M + 1][N];

        for(int i = 0; i <= M; i++)
            Arrays.fill(cache[i], -1);

        for(int i = 0; i < N; i++)
            V[i] = sc.nextInt();

        int ret = dfs(S, 0);
        System.out.println(ret < 0 ? -1 : ret);
    }

    public static int dfs(int sum, int idx) {
        if(sum > M || sum < 0)
            return Integer.MIN_VALUE;
        if(idx == N)
            return sum;

        int ret = cache[sum][idx];
        if(ret != -1)
            return ret;

        return cache[sum][idx] = Math.max(dfs(sum + V[idx], idx + 1), dfs(sum - V[idx], idx + 1));
    }
}
