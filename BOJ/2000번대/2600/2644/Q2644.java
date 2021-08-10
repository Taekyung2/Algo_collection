package boj;

import java.util.*;

public class Q2644 {
    static int n, a, b, m;
    static List<Integer>[] adj;
    static int[] visited;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        a = sc.nextInt();
        b = sc.nextInt();
        m = sc.nextInt();
        adj = new ArrayList[n + 1];
        visited = new int[n + 1];
        Arrays.fill(visited, -1);

        for(int i = 1; i <= n; i++)
            adj[i] = new ArrayList<>();

        for(int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            adj[x].add(y);
            adj[y].add(x);
        }

        Queue<Integer> q = new LinkedList<>();
        visited[a] = 0;
        q.add(a);

        while(!q.isEmpty()) {
            int cur = q.poll();
            for(int next : adj[cur]) {
                if(visited[next] != -1)
                    continue;
                q.add(next);
                visited[next] = visited[cur] + 1;
            }
        }

        System.out.println(visited[b]);
    }
}
