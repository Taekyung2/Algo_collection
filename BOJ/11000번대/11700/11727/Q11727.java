package boj;

import java.util.Scanner;

public class Q11727 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] cache = new int[N + 3];
        cache[1] = 1;
        cache[2] = 3;

        for(int i = 3; i <= N; i++)
            cache[i] = (cache[i - 1] + 2 * cache[i - 2]) % 10007;
        System.out.println(cache[N]);
    }
}

