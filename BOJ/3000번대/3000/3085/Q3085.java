package boj;

import java.util.Scanner;

public class Q3085 {
    static int N, ret = 0;
    static char[][] map;
    static int[] dy = {0, 1}, dx = {1, 0};

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        map = new char[N][N];
        for(int i = 0; i < N; i++)
            map[i] = sc.next().toCharArray();

        ret = Math.max(ret, check());
        loop:
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                for(int d = 0; d < 2; d++) {
                    int ny = i + dy[d];
                    int nx = j + dx[d];
                    if(ny >= 0 && nx >= 0 && ny < N && nx < N && map[i][j] != map[ny][nx]) {
                        swap(i, j, ny, nx);
                        ret = Math.max(ret, check());
                        swap(ny, nx, i, j);
                    }
                    if(ret == N)
                        break loop;
                }
            }
        }

        System.out.println(ret);
    }

    public static void swap(int y, int x, int ny, int nx) {
        char tmp = map[y][x];
        map[y][x] = map[ny][nx];
        map[ny][nx] = tmp;
    }

    public static int check() {
        int ans = 0;

        for(int i = 0; i < N; i++) {
            int row = 1, col = 1;
            for(int j = 0; j < N - 1; j++) {
                if(map[i][j] == map[i][j + 1])
                    row++;
                else {
                    ans = Math.max(ans, row);
                    row = 1;
                }

                if(map[j][i] == map[j + 1][i])
                    col++;
                else {
                    ans = Math.max(ans, col);
                    col = 1;
                }
            }
            ans = Math.max(ans, row);
            ans = Math.max(ans, col);
        }

        return ans;
    }
}
