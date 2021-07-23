package boj;

import java.util.Arrays;
import java.util.Scanner;

public class Q11399 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for(int i = 0; i < N; i++)
            arr[i] = sc.nextInt();

        int ret = 0;
        Arrays.sort(arr);
        for(int i = 1; i < N; i++) {
            arr[i] += arr[i - 1];
            ret += arr[i];
        }
        System.out.println(ret + arr[0]);
    }
}
