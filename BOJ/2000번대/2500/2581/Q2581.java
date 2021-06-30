package boj;

import java.util.Scanner;

public class Q2581 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int M = sc.nextInt();
        int N = sc.nextInt();
        int sum = 0, min = -1;

        for(int i = N; i >= M; i--) {
            if(isPrime(i)) {
                sum += i;
                min = i;
            }
        }

        if(sum != 0)
            System.out.println(sum);
        System.out.println(min);
    }

    public static boolean isPrime(int num) {
        if(num == 2) return true;
        if(num == 1 || num % 2 == 0) return false;

        for(int i = 3; i <= Math.sqrt(num); i+=2) {
            if(num % i == 0)
                return false;
        }

        return true;
    }
}
