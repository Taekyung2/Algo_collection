package boj;

import java.util.Scanner;

public class Q9020 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        while(tc-- > 0) {
            int num = sc.nextInt();
            for(int i = num / 2; i >= 2; i--) {
                if(isPrime(i) && isPrime(num - i)) {
                    System.out.println(i + " " + (num - i));
                    break;
                }
            }
        }
    }

    static boolean isPrime(int num) {
        if(num < 2)
            return false;
        for(int i = 2; i * i <= num; i++) {
            if(num % i == 0)
                return false;
        }
        return true;
    }
}
