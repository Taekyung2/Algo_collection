package boj;

import java.util.Scanner;

/**
 * A를 B번 곱한 수
 * - A를 B/2번 곱한 수 * A를 B/2번 곱한 수 -> B/2가 홀수라면 B 한번 더 곱함
 * ... B가 1이 되면 A리턴
 */

public class Q1629 {
    static int A, B, C;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        A = sc.nextInt();
        B = sc.nextInt();
        C = sc.nextInt();

        System.out.println(mul(A, B));
    }

    public static long mul(int a, int b) {
        if(b == 0)
            return 1;
        if(b == 1)
            return a % C;

        if(b % 2 == 0) {
            long tmp = mul(a, b / 2);
            return (tmp * tmp) % C;
        } else {
            return (a * mul(a, b - 1)) % C;
        }
    }
}
