package boj;

import java.util.Scanner;

public class Q9465 {
    static int n;
    static int[][] stick, cache;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        while(tc-- > 0) {
            n = sc.nextInt();
            stick = new int[2][n];
            cache = new int[2][n];
            for(int i = 0; i < 2; i++)
                for(int j = 0; j < n; j++)
                    stick[i][j] = sc.nextInt();
            if(n == 1) {
                System.out.println(Math.max(stick[1][0], stick[0][0]));
                continue;
            }
            cache[0][0] = stick[0][0];
            cache[1][0] = stick[1][0];
            cache[0][1] = stick[1][0] + stick[0][1];
            cache[1][1] = stick[0][0] + stick[1][1];
            for(int i = 2; i < n; i++) {
                cache[0][i] = stick[0][i] + Math.max(cache[1][i - 1], cache[1][i - 2]);
                cache[1][i] = stick[1][i] + Math.max(cache[0][i - 1], cache[0][i - 2]);
            }
            System.out.println(Math.max(cache[0][n - 1], cache[1][n - 1]));
        }
    }
}
