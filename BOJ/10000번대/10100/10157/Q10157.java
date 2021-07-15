package boj;

import java.util.Scanner;

public class Q10157 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt();
        int r = sc.nextInt();
        int k = sc.nextInt();
        boolean[][] map = new boolean[r][c];

        int[] dy = {1, 0, -1, 0}, dx = {0, 1, 0, -1};
        int y = 0, x = 0, d = 0;
        map[y][x] = true;

        if(r * c < k) {
            System.out.println(0);
            return;
        }

        while(k-- > 1) {
            int ny = y + dy[d];
            int nx = x + dx[d];

            if(ny < 0 || nx < 0 || ny >= r || nx >= c || map[ny][nx]) {
                d = (d + 1) % 4;
                ny = y + dy[d];
                nx = x + dx[d];
            }

            map[ny][nx] = true;
            y = ny;
            x = nx;
        }

        System.out.println((x + 1) + " " + (y + 1));
    }
}
