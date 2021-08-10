package boj;

/**
 * # 계획
 * 2^63 보다 작으므로 long 범위, 유클리드 호제법으로 되려나
 * 1의 개수끼리 최대공약수를 구함, 그 최대공약수 길이의 1이 답이 된다(규칙 찾음)
 */

import java.util.Scanner;

public class Q1850 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        long A = sc.nextLong();
        long B = sc.nextLong();
        System.out.println("1".repeat(gcd(A, B)));
    }

    public static int gcd(long a, long b) {
        if(b == 0) return (int) a;
        return gcd(b, a % b);
    }
}
