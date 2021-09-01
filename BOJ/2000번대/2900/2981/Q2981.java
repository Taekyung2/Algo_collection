package boj;

import java.util.Arrays;
import java.util.Scanner;

public class Q2981 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N  = sc.nextInt();
        int[] arr = new int[N];
        for(int i = 0; i < N; i++)
            arr[i] = sc.nextInt();
        Arrays.sort(arr);

        int g = arr[1] - arr[0];
        for(int i = 2; i < N; i++) {
            g = gcd(g, arr[i] - arr[i - 1]);
        }

        for(int i = 2; i <= g; i++) {
            if(g % i == 0)
                System.out.print(i + " ");
        }
    }

    public static int gcd(int a, int b) {
        if(b == 0)
            return a;
        return gcd(b, a % b);
    }
}

/**
 * 1. 주어진 숫자들을 나눴을 때 전부 같게 만드는 M을 구하라
 * 2. 전부 다 해보는건, 10억까지라서 안될 듯
 * 예제1) 6 34 38
 *   -> 34 - 6 = 28, 38 - 34 = 4, 28과 4의 약수를 구하면 될 듯?
 *
 * 예제2) 5 17 23 14 83
 *  -> 9, 3, 6, 66의 공통 약수 -> 3
 */