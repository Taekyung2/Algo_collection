package boj;

import java.util.Scanner;

public class Q1094 {
    static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        System.out.println(Integer.bitCount(N));
    }
}
