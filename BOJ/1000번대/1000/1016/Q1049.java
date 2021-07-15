package boj;

import java.util.Arrays;
import java.util.Scanner;

public class Q1049 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] single = new int[M];
        int[] set = new int[M];

        for(int i = 0; i < M; i++) {
            set[i] = sc.nextInt();
            single[i] = sc.nextInt();
        }

        Arrays.sort(set);
        Arrays.sort(single);

        int ret = Math.min(N / 6 * set[0] + N % 6 * single[0], single[0] * N);
        ret = Math.min(ret, (N / 6 + 1) * set[0]);
        System.out.println(ret);
    }
}
