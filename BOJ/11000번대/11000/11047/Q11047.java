package boj;

import java.util.Scanner;

public class Q11047 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] coin = new int[N];
        for(int i = 0; i < N; i++)
            coin[i] = sc.nextInt();

        int cur = N - 1, ret = 0;
        while(K > 0) {
            if(coin[cur] > K)
                cur--;
            else {
                ret += (K / coin[cur]);
                K %= coin[cur];
            }
        }

        System.out.println(ret);
    }
}
