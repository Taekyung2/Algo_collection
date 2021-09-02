package boj;

import java.io.*;
import java.util.*;

public class Q17070 {
    static int N;
    static int[][] map;
    static int[][][] cache;
    static int[] dy = {0, 1, 1}, dx = {1, 1, 0};

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new int[N][N];
        cache = new int[N][N][3];


        for(int r = 0; r < N; r++)
            for(int c = 0; c < N; c++) {
                map[r][c] = sc.nextInt();
                Arrays.fill(cache[r][c], -1);
            }

        System.out.println(dfs(0, 1, 0));
    }

    public static int dfs(int y, int x, int d) {
        if(y < 0 || x < 0 || y >= N || x >= N || map[y][x] == 1)
            return 0;
        // 대각선 이동할 때, 빈칸이어어야 하는 곳
        if(d == 1 && (map[y - 1][x] == 1 || map[y][x - 1] == 1))
            return 0;

        if(y == N - 1 && x == N - 1)
            return 1;

        int ret = cache[y][x][d];
        if(ret != -1)
            return ret;

        ret = 0;
        for(int dir = 0; dir < 3; dir++) {
            int ny = y + dy[dir], nx = x + dx[dir];
            // 가로 -> 세로, 세로 -> 가로 불가능
            if((d == 0 && dir == 2) || (d == 2 && dir == 0))
                continue;
            ret += dfs(ny, nx, dir);
        }

        return cache[y][x][d] = ret;
    }
}