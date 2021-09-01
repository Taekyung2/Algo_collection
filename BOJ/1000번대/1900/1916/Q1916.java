package boj;


import java.util.*;

public class Q1916 {

    static int N, M;
    static ArrayList<Edge>[] adj;
    static int S, E;

    public static void main(String[] args) {
        // 입력
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        adj = new ArrayList[N + 1];
        for(int i = 0; i < N + 1; i++) {
            adj[i] = new ArrayList<>();
        }
        for(int i = 0; i < M; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            int w = sc.nextInt();
            adj[from].add(new Edge(to, w));
        }
        S = sc.nextInt();
        E = sc.nextInt();

        // 다익스트라 시작
        int[] ret = dijkstra();
        System.out.println(ret[E]);
    }

    public static int[] dijkstra() {
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[S] = 0;
        pq.add(new Edge(S, 0));
        while(!pq.isEmpty()) {
            Edge cur = pq.poll();
            if(cur.weight > dist[cur.to]) continue;
            for(var next : adj[cur.to]) {
                int nextDistance = next.weight + cur.weight;
                if(nextDistance < dist[next.to]) {
                    dist[next.to] = nextDistance;
                    pq.add(new Edge(next.to, nextDistance));
                }
            }
        }
        return dist;
    }

    static class Edge {
        int to, weight;

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }
}

/**
 *  # 계획
 *  1. 출발지에서 도착지점까지 가는 최소 비용 구하기 -> 다익스트라, 벨만-포드, 플로이드
 *  2. 출발지가 한 곳으로 정해져있고, 음수 가중치가 없으므로 다익스트라를 사용하자
 *  3. 출발점에서 도착점을 갈 수 있는 경우만 입력으로 들어오므로 따로 처리는 안해도 될 듯
 */


