package boj;

import java.util.Scanner;

public class Q13171 {
    final static int MOD = 1_000_000_007;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        long A = sc.nextLong() % MOD;
        long X = sc.nextLong();
        long ret = 1;

        while(X > 0) {
            if(X % 2 == 1) {
                ret *= A;
                ret %= MOD;
            }

            A *= A;
            A %= MOD;
            X >>= 1;
        }

        System.out.println(ret);
    }
}