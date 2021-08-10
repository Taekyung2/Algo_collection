package boj;

import java.util.Scanner;

public class Q4963 {
    static int w, h;
    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1}, dx = {0, 1, 1, 1, 0, -1, -1, -1};
    static int[][] map;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(true) {
            w = sc.nextInt();
            h = sc.nextInt();
            int cnt = 0;
            if(w == 0 && h == 0)
                break;

            map = new int[h][w];
            for(int i = 0; i < h; i++)
                for(int j = 0; j < w; j++)
                    map[i][j] = sc.nextInt();

            for(int i = 0; i < h; i++) {
                for(int j = 0; j < w; j++) {
                    if(map[i][j] != 0) {
                        dfs(i, j);
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);
        }
    }

    public static void dfs(int y, int x) {
        map[y][x] = 0;
        for(int d = 0; d < 8; d++) {
            int ny = y + dy[d], nx = x + dx[d];
            if(ny < 0 || nx < 0 || ny >= h || nx >= w || map[ny][nx] == 0)
                continue;
            dfs(ny, nx);
        }
    }
}
