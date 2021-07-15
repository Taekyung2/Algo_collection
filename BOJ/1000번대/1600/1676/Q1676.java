package boj;

import java.util.Scanner;

public class Q1676 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int ret = 0;

        for(int i = 5; i <= N; i *= 5)
            ret += N / i;

        System.out.println(ret);
    }
}
