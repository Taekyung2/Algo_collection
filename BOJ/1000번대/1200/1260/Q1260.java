package boj;

import java.util.*;

public class Q1260 {
    static int N, M, V;
    static List<Integer>[] adj;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        V = sc.nextInt();
        adj = new ArrayList[N + 1];
        visited = new boolean[N + 1];

        for(int i = 0 ; i <= N; i++)
            adj[i] = new ArrayList<>();
        for(int i = 0; i < M; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj[u].add(v);
            adj[v].add(u);
        }

        for(List<Integer> list : adj)
            Collections.sort(list);

        dfs(V);
        sb.append("\n");
        bfs();

        System.out.println(sb);
    }

    public static void dfs(int cur) {
        visited[cur] = true;
        sb.append(cur + " ");
        for(int next : adj[cur]) {
            if(!visited[next])
                dfs(next);
        }
    }

    public static void bfs() {
        Arrays.fill(visited, false);
        visited[V] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(V);
        while(!q.isEmpty()) {
            int cur = q.poll();
            sb.append(cur + " ");
            for(int next : adj[cur]) {
                if(!visited[next]) {
                    visited[next] = true;
                    q.add(next);
                }
            }
        }
    }
}
