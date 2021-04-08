package boj_algorithm._21000번대._21200;

import java.io.*;
import java.util.*;

public class _21276_계보복원가호석 {
    static int N, M;
    static HashMap<String, Integer> hm = new HashMap<>();
    static ArrayList<Integer>[] adj, children;
    static int[] indegree;
    static String[] V;
    static int stoi(String s) { return Integer.parseInt(s); }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = stoi(br.readLine());
        V = new String[N];
        adj = new ArrayList[N];
        children = new ArrayList[N];
        indegree = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            String s = st.nextToken();
            V[i] = s;
            adj[i] = new ArrayList<>();
            children[i] = new ArrayList<>();
        }
        Arrays.sort(V);
        for(int i = 0; i < N; i++) hm.put(V[i], i);
        M = stoi(br.readLine());
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = hm.get(st.nextToken()), v = hm.get(st.nextToken());
            adj[v].add(u);
            indegree[u]++;
        }
        ArrayList<Integer> roots = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < N; i++) {
            if(indegree[i] == 0) {
                roots.add(i);
                q.add(i);
            }
        }
        while(!q.isEmpty()) {
            int cur = q.poll();
            for(int next : adj[cur]) {
                indegree[next]--;
                if(indegree[next] == 0) {
                    children[cur].add(next);
                    q.add(next);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(roots.size()).append("\n");
        Collections.sort(roots);
        roots.forEach(x -> sb.append(V[x]).append(" "));
        sb.append("\n");
        for(String s : V) {
            sb.append(s).append(" ").append(children[hm.get(s)].size()).append(" ");
            Collections.sort(children[hm.get(s)]);
            for(int child : children[hm.get(s)])
                sb.append(V[child]).append(" ");
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
