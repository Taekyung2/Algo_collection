package boj;

import java.io.*;
import java.util.*;

public class Q14500 {
    private static int[][] dy = {
            {0, 0, 0}, {1, 2, 3}, {0, 1, 1}, {1, 2, 2}, {1, 2, 2},
            {1, 1, 1}, {1, 1, 1}, {1, 1, 2}, {1, 1, 2}, {0, 1, 1},
            {0, 1, 1}, {0, 0, 1}, {1, 1, 1}, {1, 2, 1}, {1, 2, 1},
            {0, 0, 1}, {0, 0, 1}, {0, 1, 2}, {0, 1, 2}
    };
    private static int[][] dx = {
            {1, 2, 3}, {0, 0, 0}, {1, 0, 1}, {0, 0, 1}, {0, 0, -1},
            {0, 1, 2}, {0, -1, -2}, {0, 1, 1}, {0, -1, -1}, {1, 1, 2},
            {-1, -1, -2}, {1, 2, 1}, {-1, 0, 1}, {0, 0, 1}, {0, 0, -1},
            {1, 2, 2}, {-1, -2, -2}, {-1, -1, -1}, {1, 1, 1}
    };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int k = 0; k < dy.length; k++) {
                    int sum = 0;
                    sum += map[i][j];
                    for (int l = 0; l < 3; l++) {
                        int nr = i + dy[k][l];
                        int nc = j + dx[k][l];
                        if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
                            sum += map[nr][nc];
                        } else {
                            sum = 0;
                            break;
                        }
                    }
                    if (max < sum)
                        max = sum;
                }
            }
        }
        System.out.println(max);
    }
}

/**
 *  1. 테트로미노 5가지, 회전 4방향, 대칭, 총 40가지
 *  2. 모든 칸을 순회하면서 40가지 테트로미노를 전부 계산해본다.
 */