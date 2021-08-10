package boj;

/**
 * # 계획
 * map[a][b] = 2;
 * dfs(a, b) = dfs(a + 2, b) + dfs(a, b + 2);
 * dfs -> (a, b)에서 마지막 칸까지 갈 수 있는 경우의 수
 *
 * dp를 써야되나?
 */

import java.util.Arrays;
import java.util.Scanner;

public class Q1890 {
    static int N;
    static int[][] map;
    static long[][] cache;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new int[N][N];
        cache = new long[N][N];

        for(int i = 0; i < N; i++) {
            Arrays.fill(cache[i], -1);
            for (int j = 0; j < N; j++)
                map[i][j] = sc.nextInt();
        }

        System.out.println(dfs(0, 0));
    }

    public static long dfs(int y, int x) {
        if(y == N - 1 && x == N - 1)
            return 1;
        if(map[y][x] == 0)
            return 0;

        long ret = cache[y][x];
        if(ret != -1)
            return ret;

        ret = 0;

        int d = map[y][x];
        int ny = y + d, nx = x + d;

        if(ny >= 0 && ny < N)
            ret += dfs(ny, x);
        if(nx >= 0 && nx < N)
            ret += dfs(y, nx);

        return cache[y][x] = ret;
    }
}
