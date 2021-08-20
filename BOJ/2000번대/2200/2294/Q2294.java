package boj;

import java.util.*;

public class Q2294 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] cache = new int[k + 1];
        Arrays.fill(cache, k + 1);
        cache[0] = 0;
        for(int i = 0; i < n; i++) {
            int coin = sc.nextInt();
            for(int j = coin; j <= k; j++)
                cache[j] = Math.min(cache[j], cache[j - coin] + 1);
        }
        System.out.println(cache[k] >= k + 1  ? -1 : cache[k]);
    }
}
