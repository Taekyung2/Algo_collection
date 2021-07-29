package boj;

/**
 * # 계획
 *  전체 맵을 순회하면서 1이 나오면 dfs or bfs, 방문처리
 *  서치 알고리즘이 실행된 횟수가 답
 */

import java.util.Scanner;

public class Q1012 {
    static int M, N, K;
    static int[] dy = {-1, 0, 1, 0}, dx = {0, 1, 0, -1};
    static int[][] map;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        while(tc-- > 0) {
            M = sc.nextInt();
            N = sc.nextInt();
            K = sc.nextInt();
            map = new int[N][M];
            int ret = 0;
            for(int i = 0; i < K; i++) {
                 int x = sc.nextInt();
                 int y = sc.nextInt();
                 map[y][x] = 1;
            }

            for(int i = 0; i < N; i++)
                for(int j = 0; j < M; j++)
                    if(map[i][j] == 1) {
                        dfs(i, j);
                        ret++;
                    }

            System.out.println(ret);
        }
    }

    public static void dfs(int y, int x) {
        map[y][x] = 0;
        for(int d = 0; d < 4; d++) {
            int ny = y + dy[d], nx = x + dx[d];
            if(ny < 0 || nx < 0 || ny >= N || nx >= M) continue;
            if(map[ny][nx] == 1)
                dfs(ny, nx);
        }
    }
}