package boj;

import java.io.*;
import java.util.*;

public class Q10026 {
    static final int[] dy = {-1, 0, 1, 0}, dx = {0, 1, 0, -1};
    static int N, ret1, ret2;
    static char[][] board;
    static boolean[][] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        board = new char[N][N];
        visited = new boolean[N][N];
        for(int i = 0; i < N; i++)
            board[i] = sc.next().toCharArray();

        ret1 = search();
        visited = new boolean[N][N];
        for(int i = 0; i < N; i++)
            for(int j = 0; j < N; j++)
                if(board[i][j] == 'G')
                    board[i][j] = 'R';
        ret2 = search();
        System.out.println(ret1 + " " + ret2);
    }

    public static int search() {
        int ans = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(visited[i][j])
                    continue;
                visited[i][j] = true;
                bfs(new Point(i, j));
                ans++;
            }
        }
        return ans;
    }

    public static void bfs(Point start) {
        Queue<Point> q = new LinkedList<>();
        q.add(start);
        while(!q.isEmpty()) {
            Point cur = q.poll();
            for(int d = 0; d < 4; d++) {
                int ny = cur.y + dy[d];
                int nx = cur.x + dx[d];
                if(ny < 0 || nx < 0 || ny >= N || nx >= N || visited[ny][nx] || board[ny][nx] != board[cur.y][cur.x]) continue;
                visited[ny][nx] = true;
                q.add(new Point(ny, nx));
            }
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
 *  적록 색약인 사람이 봤을 때는 R과 G를 같은 값으로 생각해야 함.
 *  모든 칸을 순회하면서 그래프 탐색으로 컴포넌트 개수를 찾고,
 *  G와 R을 같은 값으로 통일 시킨 뒤 한번 더 그래프 탐색을 하면 될 것같음.
 */