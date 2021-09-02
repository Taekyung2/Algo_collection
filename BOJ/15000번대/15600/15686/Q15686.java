package boj;

import java.io.*;
import java.util.*;

public class Q15686 {
    static int n, m, ans = (int)1e9;
    static List<Point> home, chicken;
    static int[] pick;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        home = new ArrayList<>();
        chicken = new ArrayList<>();
        pick = new int[m];

        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++) {
                int a = sc.nextInt();
                if(a == 1) home.add(new Point(i, j));
                if(a == 2) chicken.add(new Point(i, j));
            }

        comb(0, 0);
        System.out.println(ans);
    }

    public static void comb(int idx, int cnt) {
        if(idx > chicken.size()) return;
        if(cnt == m) {
            int ret = 0;
            for (Point point : home) {
                int min = (int)1e9;
                for (int n : pick) {
                    Point cur = chicken.get(n);
                    min = Math.min(min, Math.abs(point.y - cur.y)
                            + Math.abs(point.x - cur.x));
                }

                ret += min;
            }
            ans = Math.min(ret, ans);
            return;
        }

        pick[cnt] = idx;
        comb(idx + 1, cnt + 1);
        comb(idx + 1, cnt);
    }

    static class Point {
        int y, x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}

/**
 *  0은 빈 칸, 1은 집, 2는 치킨집
 *  치킨 거리가 최소가 되게 치킨집을 M개 뽑고 나머지는 폐업
 *  원래 있던 치킨집들을 배열에 저장하고, 그 중 M개를 뽑는다.
 *  뽑은 M개를 가지고 모든 집을 돌며 최소 치킨 거리를 구한다.
 */