package boj_algorithm._1000번대._1700;

import java.util.*;
public class _1756_피자굽기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int D = sc.nextInt(), N = sc.nextInt();
        int[] oven = new int[D + 1];
        Arrays.fill(oven, (int)1e9);
        for(int i = 1; i <= D; i++)
            oven[i] = Math.min(oven[i - 1], sc.nextInt());
        while(N-- > 0 && D >= 0) {
            int p = sc.nextInt();
            while(oven[D--] < p);
        }
        System.out.println(D + 1);
    }
}