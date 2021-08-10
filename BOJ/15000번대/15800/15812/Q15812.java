package boj;

/**
 *  # 계획
 *  1. 4중 for문으로 독주머니를 둘 좌표 2곳을 선정하자
 *  2. 이 두 좌표와, 마을들의 거리 중 가장 먼 거리가 행성을 초토화 시킬 수 있는 시간!
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Q15812 {
    static int N, M, town = 0;
    static ArrayList<int[]> towns = new ArrayList<>();
    static char[][] map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        map = new char[N][M];
        for(int i = 0; i < N; i++) {
            String s = sc.next();
            for(int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j);
                if(map[i][j] == '1')
                    towns.add(new int[]{i, j});
            }
        }
        int ret = Integer.MAX_VALUE;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(map[i][j] == '1') continue;
                for(int ii = i; ii < N; ii++) {
                    for(int jj = (ii == i ? j + 1 : 0); jj < M; jj++) {
                        if(map[ii][jj] == '1') continue;
                        ret = Math.min(ret, getDistance(i, j, ii, jj));
                    }
                }
            }
        }
        System.out.println(ret);
    }

    public static int getDistance(int y1, int x1, int y2, int x2) {
        return towns.stream()
                .map(town -> Math.min(
                        Math.abs(town[0] - y1) + Math.abs(town[1] - x1),
                        Math.abs(town[0] - y2) + Math.abs(town[1] - x2)))
                .mapToInt(Integer::intValue)
                .max().getAsInt();
    }
}
