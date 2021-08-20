package boj;

import java.util.Scanner;

public class Q2468 {
    static int N, ret = 0;
    static int[][] map;
    static boolean[][] visited;
    static int[] dy = {-1, 0, 1, 0}, dx = {0, 1, 0, -1};

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new int[N][N];
        int max = 0;
        for(int i = 0; i < N; i++)
            for(int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
                max = Math.max(max, map[i][j]);
            }

        for(int i = 0; i <= max; i++) {
            visited = new boolean[N][N];
            getComponent(i);
        }

        System.out.println(ret);
    }

    public static void getComponent(int limit) {
        int ans = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(!visited[i][j] && map[i][j] > limit) {
                    dfs(i, j, limit);
                    ans++;
                }
            }
        }
        ret = Math.max(ret, ans);
    }

    public static void dfs(int y, int x, int limit) {
        visited[y][x] = true;
        for(int d = 0; d < 4; d++) {
            int ny = y + dy[d], nx = x + dx[d];
            if(ny < 0 || nx < 0 || ny >= N || nx >= N || visited[ny][nx] || map[ny][nx] <= limit)
                continue;
            dfs(ny, nx, limit);
        }
    }
}
