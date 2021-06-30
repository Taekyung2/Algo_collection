package boj;

import java.util.Arrays;
import java.util.Scanner;

public class Q1427 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] arr = sc.next().toCharArray();
        Arrays.sort(arr);
        for(int i = arr.length - 1; i >= 0; i--)
            System.out.print(arr[i]);
    }
}
