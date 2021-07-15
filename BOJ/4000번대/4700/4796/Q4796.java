package boj;

import java.util.Scanner;

public class Q4796 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = 1;
        while(true) {
            int L = sc.nextInt();
            int P = sc.nextInt();
            int V = sc.nextInt();

            if(L + P + V == 0) break;

            System.out.println(String.format("Case %d: %d", tc++, V / P * L + Math.min(V % P, L)));
        }
    }
}