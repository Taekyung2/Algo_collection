package boj;

/**
 * 1 <= M <= N <= 1,000,000
 * - 에라토스테네스의 체 사용
 * - prime[] -> false : 소수, true : 소수 x
 */

import java.util.Scanner;

public class Q1929 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        boolean[] prime = new boolean[1_000_001];
        int N = sc.nextInt();
        int M = sc.nextInt();
        prime[0] = prime[1] = true;
        for(int i = 2; i <= Math.sqrt(M); i++) {
            if(!prime[i])
                for(int j = i + i; j <= M; j += i) {
                    prime[j] = true;
                }
        }

        for(int i = N; i <= M; i++)
            if(!prime[i])
                System.out.println(i);
    }
}
