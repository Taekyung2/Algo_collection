package boj;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q11724 {
    static int N, M, ret = 0;
    static boolean[] visited;
    static List<Integer>[] adj;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        adj = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        for(int i = 1; i <= N; i++)
            adj[i] = new ArrayList<>();
        for(int i = 0; i < M; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj[u].add(v);
            adj[v].add(u);
        }

        for(int i = 1; i <= N; i++)
            if(!visited[i]) {
                dfs(i);
                ret++;
            }
        System.out.println(ret);
    }

    public static void dfs(int cur) {
        visited[cur] = true;

        for(int next : adj[cur]) {
            if(!visited[next])
                dfs(next);
        }
    }
}
