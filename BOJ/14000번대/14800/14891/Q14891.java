package boj;

import java.io.*;
import java.util.*;

public class Q14891 {
    static int K;
    static LinkedList<Character>[] wheel = new LinkedList[4];
    static boolean[] chk;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < 4; i++)
            wheel[i] = new LinkedList<>();

        for(int i = 0; i < 4; i++) {
            String tmp = sc.next();
            for(int j = 0; j < 8; j++)
                wheel[i].add(tmp.charAt(j));
        }

        K = sc.nextInt();
        for(int i = 0; i < K; i++) {
            chk = new boolean[4];
            rotate(sc.nextInt() - 1, sc.nextInt());
        }

        int ret = 0;
        for(int i = 0; i < 4; i++)
            if(wheel[i].get(0) == '1')
                ret += Math.pow(2, i);

        System.out.println(ret);
    }

    private static void rotate(int n, int d) {
        if(n < 0 || n >= 4 || chk[n]) return;
        chk[n] = true;
        char left = wheel[n].get(6), right = wheel[n].get(2);
        if(d == 1)
            wheel[n].addFirst(wheel[n].pollLast());
        else
            wheel[n].addLast(wheel[n].pollFirst());

        if(n != 3 && right != wheel[n + 1].get(6))
            rotate(n + 1, -d);
        if(n != 0 && left != wheel[n - 1].get(2))
            rotate(n - 1, -d);
    }
}

/**
 * 1. 연결리스트를 이용해서 톱니가 회전하는 것을 구현합니다.
 * 2. 톱니바퀴를 회전시킬 때, 양 옆의 극을 확인하고 회전할지 말지 결정합니다
 */