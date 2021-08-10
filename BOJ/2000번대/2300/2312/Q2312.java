package boj;

import java.util.Scanner;

public class Q2312 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        boolean[] prime = new boolean[100001];
        prime[0] = prime[1] = true;
        for(int i = 2; i <= Math.sqrt(100000); i++)
            if(!prime[i])
                for(int j = i + i; j <= 100000; j+=i)
                    prime[j] = true;

        while(tc-- >0 ) {
            int n = sc.nextInt();
            for(int i = 2; i <= n; i++) {
                int cnt = 0;
                while(!prime[i] && n % i == 0) {
                    cnt++;
                    n /= i;
                }
                if(cnt != 0)
                    System.out.println(i + " " + cnt);
            }
        }
    }
}
