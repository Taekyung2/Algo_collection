package boj;

import java.util.*;

public class Q2667 {
    static int[] dy = {-1, 0, 1, 0}, dx = {0, 1, 0, -1};
    static int N;
    static char[][] board;
    static List<Integer> ret = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        board = new char[N][N];
        for(int i = 0; i < N; i++)
            board[i] = sc.next().toCharArray();
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(board[i][j] == '1') {
                    board[i][j] = '0';
                    bfs(new Point(i, j));
                }
            }
        }
        Collections.sort(ret);
        System.out.println(ret.size());
        ret.forEach(System.out::println);
    }

    public static void bfs(Point start) {
        Queue<Point> q = new LinkedList<>();
        q.add(start);
        int cnt = 1;
        while(!q.isEmpty()) {
            Point cur = q.poll();
            for(int d = 0; d < 4; d++) {
                int ny = cur.y + dy[d];
                int nx = cur.x + dx[d];
                if(ny < 0 || nx < 0 || ny >= N || nx >= N || board[ny][nx] == '0') continue;
                cnt++;
                board[ny][nx] = '0';
                q.add(new Point(ny, nx));
            }
        }
        ret.add(cnt);
    }

    static class Point {
        int y, x;

        Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}

