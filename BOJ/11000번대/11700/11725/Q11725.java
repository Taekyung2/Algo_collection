package boj;

import java.util.*;

public class Q11725 {
    static int N;
    static int[] parent;
    static boolean[] visited;
    static List<Integer>[] adj;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        adj = new ArrayList[N + 1];
        parent = new int[N + 1];
        visited = new boolean[N + 1];

        for(int i = 1; i <= N; i++)
            adj[i] = new ArrayList<>();

        for(int i = 0; i < N - 1; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj[u].add(v);
            adj[v].add(u);
        }

        dfs(1);
        Arrays.stream(parent)
                .skip(2)
                .forEach(System.out::println);
    }

    public static void dfs(int cur) {
        visited[cur] = true;

        for(int next : adj[cur]) {
            if(!visited[next]) {
                parent[next] = cur;
                dfs(next);
            }
        }
    }
}
