package boj;

import java.util.Scanner;

public class Q1309 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] cache = new int[N + 1];
        cache[0] = 1;
        cache[1] = 3;
        for(int i = 2; i <= N; i++) {
            cache[i] = (2 * cache[i - 1] + cache[i - 2]) % 9901;
        }
        System.out.println(cache[N]);
    }
}
