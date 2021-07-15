package boj;

import java.util.Scanner;

public class Q1244 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n + 1];
        for(int i = 1; i <= n; i++)
            arr[i] = sc.nextInt();
        int m = sc.nextInt();
        for(int i = 0; i < m; i++)
            simulation(arr, sc.nextInt(), sc.nextInt());

        for(int i = 1; i <= n; i++) {
            System.out.print(arr[i] + " ");
            if(i % 20 == 0)
                System.out.println();
        }
    }

    public static void simulation(int[] arr, int sex, int num) {
        if(sex == 1) {
            for(int i = num; i < arr.length; i += num)
                arr[i] = (arr[i] + 1) % 2;
        } else {
            int left = num, right = num;
            while(true) {
                left--;
                right++;
                if(left < 1 || right >= arr.length) break;
                if(arr[left] != arr[right]) break;
            }
            left++;
            right--;
            for(int i = left; i <= right; i++)
                arr[i] = (arr[i] + 1) % 2;
        }
    }
}
