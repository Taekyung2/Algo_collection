package boj;

import java.util.Scanner;

public class Q14490 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] s = sc.next().split(":");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        int g = gcd(n, m);
        System.out.println((n / g) + ":" + (m / g));
    }

    public static int gcd(int a, int b) {
        if(b == 0)
            return a;
        return gcd(b, a % b);
    }
}
