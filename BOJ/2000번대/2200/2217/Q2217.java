package boj;

import java.util.Arrays;
import java.util.Scanner;

public class Q2217 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        int ret = 0;

        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        Arrays.sort(arr);
        for(int i = 0; i < n; i++)
            ret = Math.max(ret, (n - i) * arr[i]);

        System.out.println(ret);
    }
}
