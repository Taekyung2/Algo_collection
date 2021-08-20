package boj;

import java.util.*;

public class Q1927 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        var pq = new PriorityQueue<>(100000, Integer::compareTo);
        var sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            int r = sc.nextInt();
            if(r != 0) pq.offer(r);
            else {
                if(pq.isEmpty()) sb.append(0).append("\n");
                else sb.append(pq.poll()).append("\n");
            }
        }
        System.out.println(sb);
    }
}
