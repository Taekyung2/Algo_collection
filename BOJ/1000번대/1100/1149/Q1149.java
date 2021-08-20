package boj;

import java.util.Scanner;

public class Q1149 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] cache = new int[3][n + 1];
        for(int i = 1; i <= n; i++) {
            int r = sc.nextInt();
            int g = sc.nextInt();
            int b = sc.nextInt();
            cache[0][i] = Math.min(cache[1][i - 1], cache[2][i - 1]) + r;
            cache[1][i] = Math.min(cache[0][i - 1], cache[2][i - 1]) + g;
            cache[2][i] = Math.min(cache[0][i - 1], cache[1][i - 1]) + b;
        }
        System.out.println(Math.min(cache[0][n], Math.min(cache[1][n], cache[2][n])));
    }
}
