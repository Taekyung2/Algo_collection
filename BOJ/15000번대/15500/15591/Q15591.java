package boj;

import java.io.*;
import java.util.*;

public class Q15591 {
    static int N, Q;
    static List<Edge>[] adj;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        Q = sc.nextInt();
        adj = new ArrayList[N + 1];

        for(int i = 0; i < N + 1; i++)
            adj[i] = new ArrayList<>();

        for(int i = 0; i < N - 1; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            int u = sc.nextInt();
            adj[from].add(new Edge(to, u));
            adj[to].add(new Edge(from, u));
        }

        for(int i = 0; i < Q; i++) {
            int k = sc.nextInt();
            int v = sc.nextInt();
            int ret = 0;

            boolean[] visited = new boolean[N + 1];
            visited[v] = true;
            Queue<Edge> q = new LinkedList<>();
            q.add(new Edge(v, 0));
            while(!q.isEmpty()) {
                Edge cur = q.poll();
                for(Edge e : adj[cur.to]) {
                    if(visited[e.to] || e.u < k) continue;
                    q.add(e);
                    visited[e.to] = true;
                    ret++;
                }
            }

            System.out.println(ret);
        }
    }

    static class Edge {
        int to, u;

        public Edge(int to, int u) {
            this.to = to;
            this.u = u;
        }
    }
}

/**
 *  1. N개의 정점에 N - 1개의 동영상 쌍이 있기 때문에, 트리 모양, 모든 정점으로 갈 수 있다.
 *  2. 탐색을 진행하며, 유사도가 K보다 작은 경우가 나오면, 그 이후는 어차피 K보다 작은 유사도이기 때문에 탐색을 멈춘다
 */