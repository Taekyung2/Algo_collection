package boj;

import java.util.Scanner;

public class Q2477 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();
        int[] arr = new int[6];
        for(int i = 0; i < 6; i++) {
            sc.nextInt();
            int len = sc.nextInt();
            arr[i] = len;
        }

        int max = 0, area = 0, idx = 0;
        for(int i = 0; i < 6; i++) {
            area = arr[i] * arr[(i + 1) % 6];

            if(max < area) {
                max = area;
                idx = i;
            }
        }

        int ret = max - (arr[(idx + 3) % 6] * arr[(idx + 4) % 6]);
        System.out.println(ret * K);
    }
}
