package boj;

import java.io.*;
import java.util.*;

public class Q14503 {
    static int N, M, d, ret = 0;
    static int[][] map;
    static Point cleaner;
    static int[] dy = {-1, 0, 1, 0}, dx = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N][M];
        int r = sc.nextInt();
        int c = sc.nextInt();
        d = sc.nextInt();
        for(int i = 0; i < N; i++)
            for(int j = 0; j < M; j++)
                map[i][j]= sc.nextInt();

        cleaner = new Point(r, c);
        clean();

        for(int i = 0; i < N; i++)
            for (int j = 0; j < M; j++)
                if (map[i][j] == 2)
                    ret++;

        System.out.println(ret);
    }

    private static void clean() {
        loop:
        while(true) {
            map[cleaner.y][cleaner.x] = 2;
            int c = 0;
            while (c != 4) {
                if (d == 0) d = 3;
                else d--;
                int ny = cleaner.y + dy[d];
                int nx = cleaner.x + dx[d];
                if (ny < 0 || nx < 0 || ny >= N || nx >= M) {
                    c++;
                    continue;
                }

                if (map[ny][nx] == 0) {
                    cleaner.y = ny;
                    cleaner.x = nx;
                    continue loop;
                }
                c++;
            }
            int by = cleaner.y - dy[d];
            int bx = cleaner.x - dx[d];
            if(by < 0 || bx < 0 || by >= N || bx >= M || map[by][bx] == 1) break;
            cleaner.y = by;
            cleaner.x = bx;
        }
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
 *  1. 현재 위치를 청소한다.
 *  2. 현재 위치에서 현재 방향을 기준으로 왼쪽 방향부터 차례대로 인접한 칸을 탐색한다.
 *      a. 왼쪽 방향에 아직 청소하지 않은 공간이 존재한다면, 그 방향으로 회전한 다음 한 칸을 전진하고 1번부터 진행한다.
 *      b. 왼쪽 방향에 청소할 공간이 없다면, 그 방향으로 회전하고 2번으로 돌아간다.
 *      c. 네 방향 모두 청소가 이미 되어있거나 벽인 경우에는, 바라보는 방향을 유지한 채로 한 칸 후진을 하고 2번으로 돌아간다.
 *      d. 네 방향 모두 청소가 이미 되어있거나 벽이면서, 뒤쪽 방향이 벽이라 후진도 할 수 없는 경우에는 작동을 멈춘다.
 *
 *  3. 문제에서 요구하는 순서대로 정확하게 구현하자
 */