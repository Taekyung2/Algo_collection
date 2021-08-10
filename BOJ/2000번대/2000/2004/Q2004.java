package boj;

/**
 * 끝자리 0의 개수 = 5를 곱한 횟수
 *
 */

import java.util.Scanner;

public class Q2004 {
    static int n, m;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        long two = calc(2, n) - calc(2, n - m) - calc(2, m);
        long five = calc(5, n) - calc(5, n - m) - calc(5, m);
        System.out.println(Math.min(two, five));
    }

    public static long calc(int num, int val) {
        long ans = 0;
        for(long i = num; i <= val; i*=num)
            ans += (val / i);
        return ans;
    }
}