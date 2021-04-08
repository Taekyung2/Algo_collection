package boj_algorithm._21000번대._21200;

import java.math.BigInteger;
import java.util.Scanner;

public class _21275_폰호석만 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next(), b = sc.next();
        int cnt = 0, am = getMax(a), bm = getMax(b);
        int t = Math.max(am, bm);
        int[] ret = new int[3];
        BigInteger biA = new BigInteger(a, t);
        BigInteger biB = new BigInteger(b, t);
        BigInteger flag = new BigInteger("1".repeat(63));
        if(biA.compareTo(flag) > 0 || biB.compareTo(flag) > 0) {
            System.out.println("Impossible");
            return;
        }
        for(int i = am; i <= 36; i++)
            for(int j = bm; j <= 36; j++)
                if(j != i && Long.parseLong(a, i) == Long.parseLong(b, j)) {
                    cnt++;
                    ret[0] = Integer.parseInt(a, i);
                    ret[1] = i;
                    ret[2] = j;
                }
        if(cnt == 1) {
            for(int n : ret)
                System.out.print(n + " ");
        } else if(cnt == 0) {
            System.out.println("Impossible");
        } else if(cnt >= 2) {
            System.out.println("Multiple");
        }
    }

    static int getMax(String s) {
        int max = 2;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(Character.isDigit(c))
                max = Math.max(max, c - '0' + 1);
            else
                max = Math.max(max, c - 'a' + 11);
        }
        return max;
    }
}