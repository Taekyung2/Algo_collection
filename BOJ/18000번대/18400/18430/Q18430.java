package boj;

import java.util.Scanner;

public class Q18430 {
    static int N, M, ret = 0;
    static int[][] board;
    static boolean[][] cover;
    static int[][] dy = {{0, 0, 1}, {0, 1, 1}, {0, 1, 1}, {0, 0, 1}};
    static int[][] dx = {{0, 1, 1}, {0, 0, 1}, {0, 0, -1}, {1, 0, 0}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        board = new int[N][M];
        cover = new boolean[N][M];

        for(int i = 0; i < N; i++)
            for(int j = 0; j < M; j++)
                board[i][j] = sc.nextInt();

        backtrack(0, 0, 0);
        System.out.println(ret);
    }


    public static void backtrack(int y, int x, int sum) {
        if(x == M) {
            y++;
            x = 0;
        }

        if(y == N) {
            ret = Math.max(ret, sum);
            return;
        }

        if(!cover[y][x]) {
            for (int type = 0; type < 4; type++) {
                int part = 0, d;

                for (d = 0; d < 3; d++) {
                    int ny = y + dy[type][d];
                    int nx = x + dx[type][d];

                    if (ny < 0 || nx < 0 || ny >= N || nx >= M || cover[ny][nx]) break;
                    cover[ny][nx] = true;
                    part += board[ny][nx];
                }

                if (d == 3)
                    backtrack(y, x + 1, sum + part + board[y + dy[type][1]][x + dx[type][1]]);

                for (int i = 0; i < d; i++) {
                    int ny = y + dy[type][i];
                    int nx = x + dx[type][i];
                    cover[ny][nx] = false;
                }
            }
        }

        backtrack(y, x + 1, sum);
    }
}
