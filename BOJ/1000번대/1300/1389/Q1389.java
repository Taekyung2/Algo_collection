package boj;

import java.util.Arrays;
import java.util.Scanner;

public class Q1389 {
    static int N, M;
    static int[][] adj;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        adj = new int[N + 1][N + 1];

        for(int i = 1; i <= N; i++)
            Arrays.fill(adj[i], 100_000);

        for(int i = 0; i < M; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj[u][v] = 1;
            adj[v][u] = 1;
        }

        floyd();
        int ret = 0, min = Integer.MAX_VALUE;

        for(int i = 1; i <= N; i++) {
            int sum = 0;
            for(int j = 1; j <= N; j++) {
                sum += adj[i][j];
            }
            if(min > sum) {
                ret = i;
                min = sum;
            }
        }
        System.out.println(ret);
    }

    public static void floyd() {
        for(int i = 1; i <= N; i++)
            adj[i][i] = 0;

        for(int k = 1; k <= N; k++) {
            for(int i = 1; i <= N; i++) {
                if(adj[i][k] == 0) continue;
                for(int j = 1; j <= N; j++)
                    adj[i][j] = Math.min(adj[i][j], adj[i][k] + adj[k][j]);
            }
        }
    }
}
