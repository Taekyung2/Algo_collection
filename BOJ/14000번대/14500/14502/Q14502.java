package boj;

import java.io.*;
import java.util.*;

public class Q14502 {
    static int N, M, ret = 0;
    static int[][] map;
    static int[] dy = {-1, 0, 1, 0}, dx = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N][M];
        for(int i = 0; i < N; i++)
            for(int j = 0; j < M; j++)
                map[i][j] = sc.nextInt();

        pick(0, 0, 0);
        System.out.println(ret);
    }

    private static void pick(int cnt, int y, int x) {
        if(cnt == 3) {
            ret = Math.max(ret, bfs());
            return;
        }

        for(int i = y; i < N; i++) {
            int k = i == y ? x : 0;
            for(int j = k; j < M; j++) {
                if(map[i][j] == 0) {
                    map[i][j] = 1;
                    pick(cnt + 1, i, j);
                    map[i][j] = 0;
                }
            }
        }
    }

    private static int bfs() {
        int[][] tmp = new int[N][M];
        for(int i = 0; i < N; i++)
            tmp[i] = map[i].clone();

        Queue<Point> q = new LinkedList<>();

        for(int i = 0; i < N; i++)
            for(int j = 0; j < M; j++)
                if(tmp[i][j] == 2)
                    q.add(new Point(i, j));

        while(!q.isEmpty()) {
            Point cur = q.poll();
            for(int d = 0; d < 4; d++) {
                int ny = cur.y + dy[d];
                int nx = cur.x + dx[d];
                if(ny < 0 || nx < 0 || ny >= N || nx >= M || tmp[ny][nx] != 0) continue;
                tmp[ny][nx] = 2;
                q.add(new Point(ny, nx));
            }
        }

        return (int) Arrays.stream(tmp)
                .flatMapToInt(Arrays::stream)
                .filter(n -> n == 0)
                .count();
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
 *  1. N * M 크기의 지도에서 빈칸 중에 3군데를 골라서 벽을 세워본다.
 *  2. 큐에 바이러스를 넣고, 더 이상 퍼질 수 없을 때까지 bfs를 한다
 *  3. bfs가 끝나고 빈칸의 개수가 최대인 값을 구한다
 */