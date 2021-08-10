package boj;

/**
 * # 계획
 * 1. 특정한 도시 x에서 갈 수 있는 모든 도시 중 최단 거리가 K인 모든 도시를 출력
 * 2. bfs 한 번이면 가능할 듯?
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Q18352 {
    static int N, M, K, X;
    static ArrayList<Integer>[] adj;
    static List<Integer> ret = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = stoi(st.nextToken());
        M = stoi(st.nextToken());
        K = stoi(st.nextToken());
        X = stoi(st.nextToken());

        adj = new ArrayList[N + 1];
        for(int i = 1; i <= N; i++)
            adj[i] = new ArrayList<>();

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = stoi(st.nextToken());
            int v = stoi(st.nextToken());
            adj[u].add(v);
        }
        bfs(X);
        if(ret.isEmpty())
            System.out.println(-1);
        else
            ret.forEach(System.out::println);
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static void bfs(int s) {
        int[] distance = new int[N + 1];
        Arrays.fill(distance, -1);
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        distance[s] = 0;

        while(!q.isEmpty()) {
            int cur = q.poll();
            if(distance[cur] == K)
                ret.add(cur);

            for(int next : adj[cur]) {
                if(distance[next] == -1) {
                    distance[next] = distance[cur] + 1;
                    q.add(next);
                }
            }
        }
    }
}
