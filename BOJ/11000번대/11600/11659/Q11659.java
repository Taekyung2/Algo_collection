package boj;

import java.util.Scanner;

public class Q11659 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M  =sc.nextInt();
        int[] arr = new int[N + 1];
        arr[1] = sc.nextInt();
        for(int i = 2; i <= N; i++)
            arr[i] += arr[i - 1] + sc.nextInt();
        for(int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.println(arr[b] - arr[a - 1]);
        }
    }
}
