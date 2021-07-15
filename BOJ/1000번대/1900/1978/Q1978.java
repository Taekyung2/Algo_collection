package boj;

import java.util.Scanner;

public class Q1978 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int ret = 0;

        for(int i = 0; i < N; i++)
            if(isPrime(sc.nextInt()))
                ret++;
        System.out.println(ret);
    }

    public static boolean isPrime(int n) {
        if(n == 2)
            return true;
        if(n == 1 || n % 2 == 0)
            return false;

        for(int i = 3; i <= Math.sqrt(n); i += 2)
            if(n % i == 0)
                return false;
        return true;
    }
}
