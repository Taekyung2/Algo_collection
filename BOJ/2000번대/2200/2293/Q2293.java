package boj;

import java.util.Scanner;

public class Q2293 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] cache = new int[k + 1];
        cache[0] = 1;
        for(int i = 0; i < n; i++) {
            int coin = sc.nextInt();
            for(int j = coin; j <= k; j++)
                cache[j] += cache[j - coin];
        }
        System.out.println(cache[k]);
    }
}
