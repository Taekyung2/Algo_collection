package boj;

import java.util.Scanner;

public class Q1182 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int S = sc.nextInt();
        int[] arr = new int[N];
        int ret = 0;
        for(int i = 0; i < N; i++)
            arr[i] = sc.nextInt();

        for(int i = 1; i < (1 << N); i++) {
            int sum = 0;
            for(int j = 0; j < N; j++) {
                if((i & (1 << j)) != 0)
                    sum += arr[j];
            }

            if(S == sum)
                ret++;
        }

        System.out.println(ret);
    }
}
