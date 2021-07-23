package boj;

import java.util.Scanner;

public class Q1699 {
    static int[] cache;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        cache = new int[N + 1];
        for(int i = 1; i <= N; i++) {
            cache[i] = i;
            for(int j = 1; j <= Math.sqrt(i); j++)
                cache[i] = Math.min(cache[i], cache[i - j * j] + 1);
        }

        System.out.println(cache[N]);
    }
}
