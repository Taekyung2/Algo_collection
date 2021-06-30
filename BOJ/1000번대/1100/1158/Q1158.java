package boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q1158 {
    // Variable
    static int N, K;

    public static void main(String[] args) {
        // Input
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();

        // Logic
        Queue<Integer> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder("<");
        int idx = 1;

        for(int i = 1; i <= N; i++)
            q.offer(i);

        while(!q.isEmpty()) {
            if(idx < K) {
                idx++;
                q.offer(q.remove());
            }
            else {
                idx = 1;
                sb.append(q.remove()).append(", ");
            }
        }

        // Output
        System.out.println(sb.substring(0, sb.length() - 2) + ">");
    }
}