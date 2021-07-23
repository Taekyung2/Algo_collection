package boj;

import java.util.Scanner;

public class Q15650 {
    static int N, M;
    static int[] pick;
    static boolean[] chk;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        pick = new int[M];
        chk = new boolean[N + 1];

        perm( 0, 0);
    }

    public static void perm(int idx, int cnt) {
        if(cnt == M) {
            for(int n : pick)
                System.out.print(n + " ");
            System.out.println();
            return;
        }

        for(int i = idx + 1; i <= N; i++) {
            if(!chk[i]) {
                chk[i] = true;
                pick[cnt] = i;
                perm(i, cnt + 1);
                chk[i]= false;
            }
        }
    }
}
