package boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q2636 {
    static int Y, X, piece = 0, ret = 0;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int[][] map;
    static boolean[][] check;

    public static void bfs() {
        check = new boolean[Y][X];
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0, 0));
        check[0][0] = true;
        while(!q.isEmpty()) {
            Point now = q.poll();
            for(int d = 0; d < 4; d++) {
                int ny = now.y + dy[d];
                int nx = now.x + dx[d];
                if(ny < 0 || nx < 0 || ny >= Y || nx >= X || check[ny][nx]) continue;
                if(map[ny][nx] >= 1) {
                    map[ny][nx]++;
                    continue;
                }
                q.add(new Point(ny, nx));
                check[ny][nx] = true;
            }
        }
    }

    public static boolean melt() {
        int cnt = 0;
        for(int i = 0; i < Y; i++) {
            for(int j = 0; j < X; j++) {
                if(map[i][j] >= 2) {
                    map[i][j] = 0;
                    cnt++;
                }
            }
        }
        if(cnt > 0) piece = cnt;
        return cnt != 0;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Y = in.nextInt();
        X = in.nextInt();
        map = new int[Y][X];
        for(int i = 0; i < Y; i++)
            for(int j = 0; j < X; j++)
                map[i][j] = in.nextInt();
        while(true) {
            bfs();
            if(melt()) ret++;
            else break;
        }
        System.out.println(ret);
        System.out.println(piece);
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
 * 1. 1. 치즈로 둘러싸인 공기는 제외하고, 외부 공기에 접촉되면 안되므로, 판의 가장자리에서 bfs를 한다
 * 2. bfs를 돌면서 치즈를 만나면, 지워야 할 치즈이므로 표시를 해둔다
 * 3. 치즈를 다 지울 때까지 반복
 */
