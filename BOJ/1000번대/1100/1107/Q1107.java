package boj;

import java.util.Scanner;

public class Q1107 {
    static boolean[] chk; // 고장난 버튼 체크, false면 고장 안난 거, true가 고장난 거
    static int ret, N, M;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        chk = new boolean[10];

        for(int i = 0; i < M; i++)
            chk[sc.nextInt()] = true;

        ret = Math.abs(N - 100); // 100번부터 위아래 버튼으로만 갔을 때가 초기값
        dfs(0, 0);
        System.out.println(ret);
    }

    public static void dfs(int len, int cur) {
        if(len == 6)
            return;

        cur *= 10;
        for(int i = 0; i < 10; i++) {
            if(!chk[i]) {
                ret = Math.min(ret, Math.abs(N - (cur + i)) + len + 1);
                dfs(len + 1, cur + i);
            }
        }
    }
}

/**
 *  # 계획
 *  1. (고장나지 않은 버튼들로 만들 수 있는 채널들 - 목표 채널)의 최솟값
 *  2. 목표 채널은 50000 이하이므로 6자리수까지 만들어보면 될 듯, 6!
 */