package boj;

/**
 * # 계획
 * 역방향 간선으로 그래프 생성
 * dfs N번 실행은 .. 될거같기도
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1325 {
    static int N, M;
    static int[] cnt;
    static boolean[] visited;
    static List<Integer>[] adj;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        adj = new ArrayList[N + 1];
        cnt = new int[N + 1];

        for(int i = 0; i <= N; i++)
            adj[i] = new ArrayList<>();

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adj[u].add(v);
        }

        for(int i = 1; i <= N; i++) {
            visited = new boolean[N + 1];
            dfs(i);
        }

        StringBuilder sb = new StringBuilder();
        int max = Arrays.stream(cnt).max().getAsInt();

        for(int i = 1; i <= N; i++)
            if(cnt[i] == max)
                sb.append(i).append(" ");
        System.out.println(sb);
    }

    public static void dfs(int cur) {
        visited[cur] = true;
        for(int next : adj[cur]) {
            if(visited[next]) continue;
            dfs(next);
            cnt[next]++;
        }
    }
}
