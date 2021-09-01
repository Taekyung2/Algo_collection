package boj;

import java.util.*;

public class Q1068 {
    static int N, root, delete;
    static List<Integer>[] adj;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        adj = new List[N];
        for(int i = 0; i < N; i++)
            adj[i] = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            int parent = sc.nextInt();
            if(parent != -1) {
                adj[parent].add(i);
            } else
                root = i;
        }
        delete = sc.nextInt();

        System.out.println(bfs());
    }

    public static int bfs() {
        int ans = 0;
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[N];
        q.add(root);
        visited[root] = true;

        while(!q.isEmpty()) {
            int cur = q.poll();
            if(cur == delete)
                continue;
            if(adj[cur].size() == 0 ||
                    (adj[cur].contains(delete) && adj[cur].size() == 1))
                ans++;
            for(var next : adj[cur]) {
                if(visited[next]) continue;
                visited[next] = true;
                q.add(next);
            }
        }
        return ans;
    }
}

/**
 * 1. 각 노드의 부모를 알고 있기 때문에, 부모 노드에서 자식 노드로 갈 수 있는 방향 그래프를 만들자
 * 2. 루트에서 bfs or dfs를 하면서, 지울 노드의 번호가 나오면 break;
 * 3. 자식 노드가 없다면 리프 노드이므로 카운트
 * % 노드를 지웠을 때 부모 노드가 리프노드가 될 경우를 카운트하자
 */