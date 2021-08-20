package boj;

import java.util.*;

public class Q2178 {
    static class Point {
        int y, x;

        Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    static int[] dy = {-1, 0, 1, 0}, dx = {0, 1, 0, -1};
    static char[][] board;
    static int n, m;
    static int[][] distance;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        board = new char[n][m];
        distance = new int[n][m];
        for(int i = 0; i < n; i++) {
            board[i] = sc.next().toCharArray();
            Arrays.fill(distance[i], -1);
        }
        bfs();
        System.out.println(distance[n - 1][m - 1]);
    }


    public static void bfs() {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0, 0));
        distance[0][0] = 1;
        while(!q.isEmpty()) {
            Point cur = q.poll();
            for(int d = 0; d < 4; d++) {
                int ny = cur.y + dy[d], nx = cur.x + dx[d];
                if(ny < 0 || nx < 0 || ny >= n || nx >= m || board[ny][nx] == '0' || distance[ny][nx] != -1) continue;
                q.add(new Point(ny, nx));
                distance[ny][nx] = distance[cur.y][cur.x] + 1;
            }
        }
    }
}
