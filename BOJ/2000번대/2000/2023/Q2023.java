package boj;

import java.util.Scanner;

public class Q2023 {
    static int N;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        for(int i = 1; i < 10; i++) {
            if(isPrime(i))
                solve(i, 1);
        }
    }

    public static void solve(int cur, int cnt) {
        if(cnt == N) {
            System.out.println(cur);
            return;
        }

        cur *= 10;
        for(int i = 1; i < 10; i++) {
            if(isPrime(cur + i))
                solve(cur + i, cnt + 1);
        }
    }

    public static boolean isPrime(int num) {
        if(num <= 1)
            return false;
        for(int i = 2; i * i <= num; i++) {
            if(num % i == 0)
                return false;
        }
        return true;
    }
}

/**
 * # 계획
 * 1. N = 8이니까 8!, 시간 충분
 * 2. 1자리부터 N자리까지 하나씩 숫자 붙여가면서 소수인지 확인
 * 3. N자리까지 전부 소수였으면 출력
 */
