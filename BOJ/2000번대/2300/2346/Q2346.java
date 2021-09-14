package boj;

import java.io.*;
import java.util.*;

public class Q2346 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Deque<Balloon> deq = new ArrayDeque<>();
        for(int i = 0; i < n; i++)
            deq.add(new Balloon(i + 1, sc.nextInt()));

        StringBuilder sb = new StringBuilder();

        while(deq.size() > 1) {
            Balloon cur = deq.poll();
            sb.append(cur.idx).append(" ");
            int move = cur.num;
            if(move < 0) {
                while(move++ < 0)
                    deq.addFirst(deq.pollLast());
            } else {
                move--;
                while(move-- > 0)
                    deq.addLast(deq.pollFirst());
            }
        }

        System.out.println(sb.append(Objects.requireNonNull(deq.poll()).idx));
    }

    static class Balloon {
        int idx, num;

        Balloon(int idx, int num) {
            this.idx = idx;
            this.num = num;
        }
    }
}

/**
 * 덱 사이즈 s
 * 만약 -5라면, s는 3 , (s - (5 % s))
 * 만약 5라면 s는 3, (5 % s)
 */