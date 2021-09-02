package boj;

import java.io.*;
import java.util.*;

public class Q15683 {

    static int N, M, ret = Integer.MAX_VALUE;
    static int[][] map;
    static ArrayList<Point> al = new ArrayList<>();
    static int[] dy = {-1, 0, 1, 0}, dx = {0, 1, 0, -1};
    static int u = 1, r = 1 << 1, d = 1 << 2, l = 1 << 3;
    static int[][] cctv = {
            {u, r, d, l},
            {u|d, r|l},
            {u|r, r|d, d|l, l|u},
            {u|r|d, r|d|l, d|l|u, l|u|r},
            {u|r|d|l}
    };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N][M];
        for(int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();
                if(map[i][j] != 0 && map[i][j] != 6)
                    al.add(new Point(i, j, map[i][j]));
            }
        }

        int[] d = new int[al.size()];
        sol(0, d);
        System.out.println(ret);
    }

    public static void sol(int cur, int[] d) {
        if(cur == d.length) {
            ret = Math.min(ret, observe(d));
            return;
        }

        for(int i = 0; i < cctv[al.get(cur).n - 1].length; i++) {
            d[cur] = cctv[al.get(cur).n - 1][i];
            sol(cur + 1, d);
        }
    }

    public static int observe(int[] d) {
        int[][] tmp = new int[N][M];

        for(int i = 0; i < N; i++)
            tmp[i] = map[i].clone();

        for(int i = 0; i < d.length; i++) {
            int cur_d = d[i];
            Point cur_p = al.get(i);

            for(int k = 0; k < 4; k++) {
                if((cur_d & (1 << k)) != 0) {
                    int ny = cur_p.y;
                    int nx = cur_p.x;
                    while(ny >= 0 && nx >= 0 && ny < N && nx < M && tmp[ny][nx] != 6) {
                        tmp[ny][nx] = al.get(i).n;
                        ny += dy[k];
                        nx += dx[k];
                    }
                }
            }
        }

        int cnt = 0;
        for(int i = 0; i < N; i++)
            for(int j = 0; j < M; j++)
                if(tmp[i][j] == 0)
                    cnt++;

        return cnt;
    }

    static class Point {
        int y, x, n;

        public Point(int y, int x, int n) {
            this.y = y;
            this.x = x;
            this.n = n;
        }
    }
}

/**
 * 1. 전체 사무실을 순회하면서 CCTV가 나오면, CCTV의 번호에 맞는 방향으로 감시 영역을 표시한다, 감시 영역의 방향은 종류에 따라 4가지, 2가지, 1가지가 된다
 * 2. 모든 CCTV의 감시 영역 표시가 끝나면 사각지대의 영역을 카운트한다.
 */