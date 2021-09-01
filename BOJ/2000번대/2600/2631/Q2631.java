package boj;

import java.util.Scanner;

public class Q2631 {
    static int N;
    static int[] children, cache;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        children = new int[N + 1];
        cache = new int[N + 1];

        for(int i = 1; i <= N; i++)
            children[i] = sc.nextInt();

        // 0번 인덱스에 0번 아이를 넣었기때문에, + 1이 추가되어있으므로 1명을 더해준다
        System.out.println(N - dp(0) + 1);
    }


    public static int dp(int idx) {
        int ret = cache[idx];
        if(ret != 0)
            return ret;
        ret = 1;
        for(int next = idx + 1; next <= N; next++) {
            if(children[idx] < children[next])
                ret = Math.max(ret, dp(next) + 1);
        }

        return cache[idx] = ret;
    }
}

/**
 *  1. 예제
 *      3 7 5 2 6 1 4
 *      - 오름차순으로 정렬을 시켜야되는데, 현재 3, 5, 6이 원래 순서를 유지하는 가장 긴 순서
 *      - 3명은 제대로 줄을 서고 있으니깐, 나머지 네 명이 제 자리를 찾아가면 되겠다.
 *      즉, 주어진 수열에서 가장 긴 증가하는 수열의 길이를 구해서 전체 수에서 빼면 정답이 나오겠군.
 */