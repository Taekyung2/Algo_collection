package boj;

import java.math.BigInteger;
import java.util.Scanner;

public class Q2407 {
    static BigInteger[][] cache;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        cache = new BigInteger[n + 1][m + 1];
        for(int i = 0; i <= n; i++)
            for(int j = 0; j <= m; j++)
                cache[i][j] = BigInteger.ZERO;
        System.out.println(comb(n, m));
    }

    public static BigInteger comb(int n, int m) {
        if(n == m || m == 0)
            return BigInteger.ONE;
        if(!cache[n][m].equals(BigInteger.ZERO))
            return cache[n][m];

        return cache[n][m] = comb(n - 1, m - 1).add(comb(n - 1, m));
    }
}
