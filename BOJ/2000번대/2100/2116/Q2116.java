package boj;

import java.util.Scanner;

public class Q2116 {
    static int N;
    static int[] match = {5, 3, 4, 1, 2, 0};
    static int[][] dice;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        dice = new int[N][6];
        for(int i = 0; i < N; i++)
            for(int j = 0; j < 6; j++)
                dice[i][j] = sc.nextInt();

        int ret = 0;
        for(int i = 0; i < 6; i++)
            ret = Math.max(ret, dfs(0, dice[0][i]));
        System.out.println(ret);
    }

    public static int dfs(int cnt, int up) {
        if(cnt == N)
            return 0;
        // 현재 주사위 아래, 위 빼고 네 면중에 가장 큰거
        int ret = 0, i;
        for(i = 0; i < 6; i++)
            if(dice[cnt][i] == up)
                break;
        int next = dice[cnt][match[i]];
        for(int j = 1; j <= 6; j++) {
            if(j == up || j == next) continue;
            ret = Math.max(ret, j);
        }
        return dfs(cnt + 1, next) + ret;
    }
}

/**
 *  # 계획
 *  1. 주사위 개수 10000개 이하
 *  2. A, B, C, D, E, F -> (A, F), (B, D), (C, E)
 *  3. 어차피 나올 수 있는 경우의 수는 맨 밑 주사위를 어떻게 놓냐에 따라 6가지 경우, 즉 O(6 * 10000 * (메소드 처리 시간))
 */