package boj;

import java.util.*;

public class Q1753 {
    static int V, E;
    static List<Edge>[] adj;
    static final int INF = 300000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        V = sc.nextInt();
        E = sc.nextInt();
        int s = sc.nextInt();
        adj = new List[V + 1];

        for(int i = 1; i <= V; i++) {
            adj[i] = new ArrayList<>();
        }

        for(int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();

            adj[u].add(new Edge(v, w));
        }

        int[] ret = dijkstra(s);
        for(int i = 1; i <= V; i++) {
            if(ret[i] == INF)
                System.out.println("INF");
            else
                System.out.println(ret[i]);
        }
    }

    public static int[] dijkstra(int start) {
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
        int[] dist = new int[V + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;
        pq.add(new Edge(start, 0));

        while(!pq.isEmpty()) {
            Edge cur = pq.poll();
            if(cur.weight > dist[cur.to])
                continue;
            for(Edge next : adj[cur.to]) {
                if(dist[next.to] >= cur.weight + next.weight) {
                    dist[next.to] = cur.weight + next.weight;
                    pq.add(new Edge(next.to, cur.weight + next.weight));
                }
            }
        }
        return dist;
    }

    static class Edge {
        int to, weight;

        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }
}

/**
 *  # 계획
 *  1. 시작점이 주어지고, 다른 모든 정점으로의 최단경로를 구하면 되기 때문에 다익스트라를 사용한다
 */