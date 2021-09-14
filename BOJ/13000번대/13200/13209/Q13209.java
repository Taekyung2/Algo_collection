package boj;

import java.io.*;
import java.util.*;

public class Q13209 {
    static int N, K, cnt;
    static int[] people;
    static List<Integer>[] adj;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = stoi(br.readLine());
        while(tc-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = stoi(st.nextToken());
            K = stoi(st.nextToken());
            people = new int[N];
            adj = new ArrayList[N + 1];
            for(int i = 1 ; i<= N; i++)
                adj[i] = new ArrayList<>();

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++)
                people[i] = stoi(st.nextToken());

            for(int i = 0; i < N - 1; i++) {
                st = new StringTokenizer(br.readLine());
                int u = stoi(st.nextToken());
                int v = stoi(st.nextToken());
                adj[u].add(v);
                adj[v].add(u);
            }

            long lo = 0, hi = 0;
            for(int i = 0; i < N; i++)  {
                lo = Math.max(lo, people[i]);
                hi += people[i];
            }

            while(lo <= hi) {
                long mid = (lo + hi) / 2;
                cnt = 0;
                dfs(1, 1, mid);
                if(cnt <= K)
                    hi = mid - 1;
                else
                    lo = mid + 1;
            }

            System.out.println(hi + 1);
        }
    }

    public static long dfs(int cur, int prev, long limit) {
        Queue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());
        long curPeople = people[cur - 1];
        for(int child : adj[cur])
            if(child != prev) {
                long childPeople = dfs(child, cur, limit);
                pq.add(childPeople);
                curPeople += childPeople;
            }

        while(curPeople > limit && !pq.isEmpty()) {
            curPeople -= pq.poll();
            cnt++;
        }

        return curPeople;
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}