package boj_algorithm._12000번대._12800;

import java.util.*;

public class _12852_1로만들기2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int ret = 0;
        int[] path = new int[1000001];
        int[] dist = new int[1000001];
        Queue<Integer> q = new LinkedList<>();
        q.add(N);
        dist[N] = 1;
        while(!q.isEmpty()) {
            int cur = q.poll();
            if(cur == 1) {
                ret = dist[cur];
                break;
            }
            List<Integer> next = new ArrayList<>();
            if(cur % 3 == 0) next.add(cur / 3);
            if(cur % 2 == 0) next.add(cur / 2);
            next.add(cur - 1);
            for(int n : next) {
                if(dist[n] > 0 || n <= 0) continue;
                q.add(n);
                dist[n] = dist[cur] + 1;
                path[n] = cur;
            }
        }
        System.out.println(ret - 1);
        ArrayList<Integer> ans = new ArrayList<>();
        N = 1;
        while(N != 0) {
            ans.add(N);
            N = path[N];
        }
        Collections.reverse(ans);
        ans.forEach(x -> System.out.print(x + " "));
    }
}