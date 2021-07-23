package boj;

import java.util.Scanner;

public class Q2003 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int ret = 0;
        int N = sc.nextInt();
        long M = sc.nextLong();
        long[] arr = new long[N + 1];

        for(int i = 1; i <= N; i++)
            arr[i] = arr[i - 1] + sc.nextInt();

        for(int i = 0; i <= N; i++) {
            for(int j = 0; j < i; j++) {
                if(arr[i] - arr[j] == M)
                    ret++;
            }
        }

        System.out.println(ret);
    }
}
