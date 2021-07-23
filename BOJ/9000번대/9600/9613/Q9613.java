package boj;

import java.util.Scanner;

public class Q9613 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        while(tc-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            long ret = 0;

            for(int i = 0; i < n; i++)
                arr[i] = sc.nextInt();

            for(int i = 0; i < n - 1; i++)
                for(int j = i + 1; j < n; j++)
                    ret += gcd(arr[i], arr[j]);
            System.out.println(ret);
        }
    }

    public static int gcd(int a, int b) {
        if(b == 0) return a;
        return gcd(b, a % b);
    }
}
