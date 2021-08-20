package boj;

import java.util.Scanner;

public class Q2469 {
    static int K, N, hide;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        K = sc.nextInt();
        N = sc.nextInt();
        char[] start = new char[K];
        char[] fin = sc.next().toCharArray();
        char[] ret = new char[K - 1];
        char[][] map = new char[N][K - 1];

        for(int i = 0; i < K; i++)
            start[i] = (char) ('A' + i);

        for(int i = 0; i < N; i++) {
            String tmp = sc.next();
            if(tmp.charAt(0) == '?')
                hide = i;

            for(int j = 0; j < K - 1; j++)
                map[i][j] = tmp.charAt(j);
        }

        for(int i = 0; i < hide; i++)
            go(map[i], start);

        for(int i = N - 1; i > hide; i--)
            go(map[i], fin);

        for(int i = 0; i < K - 1; i++) {
            if(start[i] == fin[i])
                ret[i] = '*';
            else if(start[i] == fin[i + 1] && start[i + 1] == fin[i]){
                ret[i] = '-';
                swap(start, i, i + 1);
            } else {
                System.out.println("x".repeat(K - 1));
                return;
            }
        }

        System.out.println(ret);
    }

    static void go(char[] ladder, char[] people) {
        for(int i = 0; i < K - 1; i++) {
            if(ladder[i] == '-')
                swap(people, i, i + 1);
        }
    }

    static void swap(char[] arr, int a, int b) {
        char tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}
