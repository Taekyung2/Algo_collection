package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Q11279 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        while(n-- > 0) {
            int x = Integer.parseInt(br.readLine());
            if(x == 0 && pq.isEmpty()) {
                System.out.println(0);
            } else if(x == 0) {
                System.out.println(pq.poll());
            } else {
                pq.add(x);
            }
        }
    }
}
