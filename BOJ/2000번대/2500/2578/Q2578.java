package boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q2578 {
    static int[][] map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        map = new int[5][5];
        for(int i = 0; i < 5; i++)
            for(int j = 0; j < 5; j++)
                map[i][j] = sc.nextInt();

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < 25; i++)
            q.add(sc.nextInt());

        int cnt = 1;
        while(!q.isEmpty()) {
            int cur = q.poll();

            loop:
            for(int i = 0; i < 5; i++) {
                for(int j = 0; j < 5; j++) {
                    if(map[i][j] == cur) {
                        map[i][j] = 0;
                        break loop;
                    }
                }
            }

            if(check())
                break;
            cnt++;
        }

        System.out.println(cnt);
    }


    public static boolean check() {
        int ret = 0;

        int sum3 = 0, sum4 = 0;
        for(int i = 0; i < 5; i++) {
            int sum1 = 0, sum2 = 0;
            for(int j = 0; j < 5; j++) {
                sum1 += map[i][j];
                sum2 += map[j][i];
                if(i == j)
                    sum3 += map[i][j];
                if(i == 4 - j)
                    sum4 += map[i][j];
            }
            if(sum1 == 0) ret++;
            if(sum2 == 0) ret++;
        }
        if(sum3 == 0) ret++;
        if(sum4 == 0) ret++;

        return ret >= 3;
    }
}
