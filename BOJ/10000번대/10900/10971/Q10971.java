package boj;

import java.util.Scanner;

public class Q10971 {
    static int N, ret = Integer.MAX_VALUE;
    static int[] pick;
    static int[][] W;
    static boolean[] chk;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        W = new int[N][N];
        pick = new int[N];
        chk = new boolean[N];

        for(int i = 0; i < N; i++)
            for(int j = 0; j < N; j++)
                W[i][j] = sc.nextInt();
        perm(0);
        System.out.println(ret);
    }

    public static void perm(int cnt) {
        if(cnt == N) {
            int sum = 0;
            for(int i = 0; i < N - 1; i++) {
                int w = W[pick[i]][pick[i + 1]];
                if(w == 0)
                    return;
                sum += w;
            }
            if(W[pick[N - 1]][pick[0]] == 0)
                return;
            ret = Math.min(ret, sum + W[pick[N - 1]][pick[0]]);
            return;
        }

        for(int i = 0; i < N; i++) {
            if(!chk[i]) {
                chk[i] = true;
                pick[cnt] = i;
                perm(cnt + 1);
                chk[i] = false;
            }
        }
    }
}
