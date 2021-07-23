package boj;

import java.util.*;

public class Q2606 {
    static List<Integer>[] adj;
    static boolean[] visited;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
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

        System.out.println(dfs(1) - 1);
    }

    public static int dfs(int cur) {
        int ans = 1;
        visited[cur] = true;
        for(int n : adj[cur]) {
            if(!visited[n])
                ans += dfs(n);
        }
        return ans;
    }
}
