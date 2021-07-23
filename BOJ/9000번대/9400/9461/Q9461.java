package boj;

import java.util.Scanner;

public class Q9461 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        long[] cache = new long[101];
        cache[0] = 1;
        cache[1] = 1;
        cache[2] = 1;
        for(int i = 3; i <= 100; i++)
            cache[i] = cache[i - 2] + cache[i - 3];
        while(tc-- > 0) {
            System.out.println(cache[sc.nextInt() - 1]);
        }
    }
}
