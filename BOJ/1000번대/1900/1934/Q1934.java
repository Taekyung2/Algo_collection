package boj;

import java.util.Scanner;

public class Q1934 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        while(tc-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.println((a * b) / gcd(a, b));
        }
    }

    public static int gcd(int a, int b) {
        if(b == 0) return a;
        return gcd(b, a % b);
    }
}
