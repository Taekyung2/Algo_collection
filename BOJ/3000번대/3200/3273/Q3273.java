package boj;

import java.util.Arrays;
import java.util.Scanner;

public class Q3273 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for(int i = 0; i < N; i++)
            arr[i] = sc.nextInt();
        Arrays.sort(arr);
        int x = sc.nextInt();
        int ret = 0;
        for(int n : arr)
            if(Arrays.binarySearch(arr, x - n) >= 0)
                ret++;
        System.out.println(ret / 2);
    }
}
