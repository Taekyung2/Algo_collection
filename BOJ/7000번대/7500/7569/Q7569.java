package boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q7569 {
    static class Point {
        int z, y, x;

        public Point(int z, int y, int x) {
            this.z = z;
            this.y = y;
            this.x = x;
        }
    }

    static int m, n, h;
    static int[][][] board;
    static boolean[][][] visited;
    static int[] dy = {1, 0, -1, 0, 0, 0};
    static int[] dx = {0, 1, 0, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        h = sc.nextInt();
        Queue<Point> q = new LinkedList<>();
        board = new int[h][n][m];
        visited = new boolean[h][n][m];
        int cnt = 0;
        for(int i = 0; i < h; i++)
            for(int j = 0; j < n; j++)
                for(int r = 0; r < m; r++) {
                    board[i][j][r] = sc.nextInt();
                    if(board[i][j][r] == 0) cnt++;
                    if(board[i][j][r] == 1) {
                        q.add(new Point(i, j, r));
                        visited[i][j][r] = true;
                    }
                }

        int day = -1;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int c = 0; c < size; c++) {
                Point cur = q.poll();
                for(int d = 0; d < 6; d++) {
                    int nz = cur.z + dz[d];
                    int ny = cur.y + dy[d];
                    int nx = cur.x + dx[d];
                    if(nx < 0 || ny < 0 || nz < 0 || nx >= m || ny >= n || nz >= h || visited[nz][ny][nx]) continue;
                    if(board[nz][ny][nx] == 0) {
                        visited[nz][ny][nx] = true;
                        cnt--;
                        board[nz][ny][nx] = 1;
                        q.add(new Point(nz, ny, nx));
                    }
                }
            }
            day++;
        }
        if(cnt == 0) {
            System.out.println(day);
        }
        else
            System.out.println(-1);
    }
}

/**
 * 1. 익은 토마토들을 큐에 넣는다
 * 2. bfs를 돌린다
 * 3. 모두 익었는지 확인 -> 걸린 일 수 출
 */
