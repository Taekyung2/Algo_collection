package boj_algorithm._2000번대._2700;

import java.util.Arrays;
import java.util.Scanner;

public class _2752_세수정렬 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[3];
        for(int i = 0; i < 3; i++) arr[i] = sc.nextInt();
        Arrays.sort(arr);
        for(int n : arr)
            System.out.print(n + " ");
    }
}
