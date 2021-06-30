package boj_algorithm._3000;

import java.util.Scanner;

public class Q3053 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        System.out.printf("%.6f\n", Math.PI * Math.pow(r, 2));
        System.out.printf("%.6f\n", 2.0 * Math.pow(r, 2));
    }
}