package boj;

import java.util.Arrays;
import java.util.Scanner;

public class Q1915 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] map = new int[N][M];
        for(int i = 0; i < N; i++) {
            String s = sc.next();
            for(int j = 0; j < M; j++)
                map[i][j] = s.charAt(j) - '0';
        }

        for(int i = 1; i < N; i++)
            for(int j = 1; j < M; j++)
                if(map[i][j] != 0)
                    map[i][j] += Math.min(map[i - 1][j], Math.min(map[i][j - 1], map[i - 1][j - 1]));

        int max = Arrays.stream(map)
                .flatMapToInt(Arrays::stream)
                .max()
                .getAsInt();

        System.out.println(max * max);
    }
}

/**
 * 정사각형이 되려면
 * 1 1
 * 1 1 -> 이렇게 되야됨, (1, 1) 좌표 기준으로 (0, 0), (0, 1), (1, 0)의 최소값을 (1, 1)에 더한 값이 최대 정사각형의 한 변의 길이가 됨
 *
 * 1 1 1
 * 1 1 1
 * 1 1 1 -> 이 경우에 위의 공식으로 하면
 *
 * 1 1 1
 * 1 2 2
 * 1 2 3 -> 최대 길이 3, 넓이는 3 * 3 = 9
 *
 **/