package boj;

import java.util.Scanner;

public class Q1789 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long ret = 0;

        while((ret * (ret + 1) / 2) <= n)
            ret++;
        System.out.println(ret - 1);
    }
}
