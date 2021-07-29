package boj;

/**
 * # 계획
 *  1. 정렬해서 5번째와 문제 해결 수가 같은 사람을 카운트
 *
 *  2. 해결한 문제의 개수가 8개 이하이기 때문에, 카운트 배열을 만들어서 풀 수도 있을 것 같음(*)
 */

import java.util.Scanner;

public class Q15905 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] cnt = new int[9];
        for(int i = 0; i < n; i++) {
            cnt[sc.nextInt()]++;
            sc.nextInt();
        }

        int sum = 0;
        for(int i = 8; i >= 0; i--) {
            sum += cnt[i];
            if(sum >= 5)
                break;
        }

        System.out.println(sum - 5);
    }
}
