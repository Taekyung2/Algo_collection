package boj;

import java.util.Scanner;

public class Q2615 {
    static int[] dy = {-1, 0, 1, 1}, dx = {1, 1, 1, 0};

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[][] map = new int[21][21];
        for(int i = 1; i <= 19; i++)
            for(int j = 1; j <= 19; j++)
                map[i][j] = sc.nextInt();

        for(int i = 1; i <= 19; i++) {
            for(int j = 1; j <= 19; j++) {
                int cur = map[i][j];
                if(cur == 0)
                    continue;
                for(int d = 0; d < 4; d++) {
                    int ny = i + dy[d], nx = j + dx[d];
                    int by = i - dy[d], bx = j - dx[d];
                    if(map[by][bx] == cur)
                        continue;
                    int cnt = 1;
                    while(ny > 0 && nx > 0 && ny < 20 && nx < 20 && cur == map[ny][nx]) {
                        cnt++;
                        ny += dy[d];
                        nx += dx[d];
                    }
                    if(cnt == 5) {
                        System.out.println(cur);
                        System.out.println(i + " " + j);
                        return;
                    }
                }
            }
        }
        System.out.println(0);
    }
}
