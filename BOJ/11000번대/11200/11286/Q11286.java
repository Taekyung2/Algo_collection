package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Q11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = stoi(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>((n1, n2) -> {
            int abN1 = Math.abs(n1), abN2 = Math.abs(n2);
            if(abN1 == abN2)
                return n1 - n2;
            return abN1 - abN2;
        });
        StringBuilder sb = new StringBuilder();
        while(N-- > 0) {
            int n = stoi(br.readLine());
            if(n == 0) {
                if(pq.isEmpty())
                    sb.append(0).append("\n");
                else
                    sb.append(pq.poll()).append("\n");
            } else {
                pq.add(n);
            }
        }
        System.out.println(sb);
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
