package boj;

import java.util.Scanner;

public class Q11726 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] cache = new int[n + 3];
        cache[1] = 1;
        cache[2] = 2;
        for(int i = 3; i <= n; i++)
            cache[i] = (cache[i - 1] + cache[i - 2]) % 10007;
        System.out.println(cache[n]);
    }
}
