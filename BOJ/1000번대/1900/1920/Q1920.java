package boj;

import java.util.Arrays;
import java.util.Scanner;

public class Q1920 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];
        for(int i = 0; i < N; i++)
            arr[i] = sc.nextInt();
        Arrays.sort(arr);

        int M = sc.nextInt();
        for(int i = 0; i < M; i++)
            System.out.println(Arrays.binarySearch(arr, sc.nextInt()) >= 0  ? "1" : "0");
    }
}
