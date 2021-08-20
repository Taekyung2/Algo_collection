package boj;

import java.util.Scanner;

public class Q2011 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int[] cache = new int[s.length() + 1];
        int mod = 1000000;
        cache[0] = cache[1] = 1;
        for (int i = 2; i <= s.length(); i++) {
            if (s.charAt(i - 1) > '0')
                cache[i] = cache[i - 1];

            int num = (s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0');
            if (num >= 10 && num <= 26)
                cache[i] = (cache[i] + cache[i - 2]) % mod;
        }
        System.out.println(s.charAt(0)=='0' ? 0 : cache[s.length()]);
    }
}
