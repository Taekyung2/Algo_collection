package boj;

import java.util.Scanner;

public class Q1449 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int L = sc.nextInt();

        boolean[] chk = new boolean[1001];
        for(int i = 0; i < N; i++)
            chk[sc.nextInt()] = true;

        int cur = 0, ret = 0;
        while(cur <= 1000) {
            if(chk[cur]) {
                ret++;
                cur += L;
            } else
                cur++;
        }

        System.out.println(ret);
    }
}
