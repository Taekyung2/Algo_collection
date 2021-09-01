package boj;

import java.util.Scanner;

public class Q1756 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int D = sc.nextInt();
        int N = sc.nextInt();
        int[] oven = new int[D + 1];
        int prev = Integer.MAX_VALUE;
        for (int i = 1; i <= D; i++) {
            oven[i] = Math.min(prev, sc.nextInt());
            prev = oven[i];
        }

        int bottom = D;
        for(int i = 0; i < N; i++) {
            int cur = sc.nextInt();
            while(bottom >= 0 && cur > oven[bottom--]);
        }
        System.out.println(bottom + 1);
    }
}

/**
 *  # 계획
 *  1. 오븐 지름 배열을 만들 때, 현재 깊이까지 올 수 있는 최대 반죽 지름으로 설정
 *      ex) 5 6 4 3 6 2 3이라면 두번 째 6은 어차피 5에 걸려서 못들어옴. 그리고 다섯번 째 6도 앞의 3에 걸려서 들어올 수 없다
 *      변경한 배열) 5 5 4 3 3 2 2
 *  2. 오븐 지름 배열을 변경한 상태에서, 피자 반죽이 들어올 때 오븐 맨밑에서부터 가능한 깊이부터 채워나간다
 */