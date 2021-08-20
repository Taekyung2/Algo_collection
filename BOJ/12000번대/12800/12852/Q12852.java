package boj;

import java.util.*;

public class Q12852 {
    static int N;
    static List<Integer> recovered = new ArrayList<>();
    static int[] parent;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        parent = new int[N + 1];

        Queue<Integer> q = new LinkedList<>();
        parent[N] = N + 1;
        q.add(N);

        while(!q.isEmpty()) {
            int cur = q.poll();
            if(cur == 1)
                break;
            List<Integer> next = new ArrayList<>();
            if(cur % 3 == 0)
                next.add(cur / 3);
            if(cur % 2 == 0)
                next.add(cur / 2);
            next.add(cur - 1);
            for(var n : next) {
                if(parent[n] == 0) {
                    q.add(n);
                    parent[n] = cur;
                }
            }
        }

        recover(1);
        System.out.println(recovered.size() - 1);
        recovered.forEach(n -> System.out.print(n + " "));
    }

    static void recover(int idx) {
        if(parent[idx] == N + 1) {
            recovered.add(idx);
            return;
        }
        recover(parent[idx]);
        recovered.add(idx);
    }
}