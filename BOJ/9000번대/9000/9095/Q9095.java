package boj;

import java.util.Arrays;
import java.util.Scanner;

public class Q9095 {
    static int cache[] = new int[11];

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        Arrays.fill(cache, -1);

        while(tc-- > 0) {
            int n = sc.nextInt();
            System.out.println(dp(n));
        }
    }

    public static int dp(int n) {
        if(n == 1) return 1;
        if(n == 2) return 2;
        if(n == 3) return 4;

        int ret = cache[n];
        if(ret != -1)
            return ret;

        return cache[n] = dp(n - 3) + dp(n - 2) + dp(n - 1);
    }
}
