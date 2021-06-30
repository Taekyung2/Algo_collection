package boj;

import java.util.Scanner;

public class Q1292 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int idx = 0, sum = 0;

        int[] arr = new int[1001];
        loop:
        for(int i = 1; i <= 1000; i++)
            for(int j = 0; j < i; j++) {
                if(idx > 1000)
                    break loop;
                arr[idx++] = i;
            }

        for(int i = A - 1; i < B; i++)
            sum += arr[i];
        System.out.println(sum);
    }
}
