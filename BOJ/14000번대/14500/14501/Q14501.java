package boj;

import java.util.Scanner;

public class Q14501 {
    static int N, ret = 0;
    static int[] T, P;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        T = new int[N];
        P = new int[N];

        for(int i = 0; i < N; i++) {
            T[i] = sc.nextInt();
            P[i] = sc.nextInt();
        }

        dfs(0, 0);
        System.out.println(ret);
    }

    public static void dfs(int cur, int sum) {
        if(cur == N) {
            ret = Math.max(ret, sum);
            return;
        }

        if(cur + T[cur] <= N)
            dfs(cur + T[cur], sum + P[cur]);
        dfs(cur + 1, sum);
    }
}
