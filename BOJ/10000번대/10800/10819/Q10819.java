package boj;

import java.util.Scanner;

public class Q10819 {
    static int N, ret = 0;
    static int[] arr, pick;
    static boolean[] chk;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N];
        pick = new int[N];
        chk = new boolean[N];

        for(int i = 0; i < N; i++)
            arr[i] = sc.nextInt();
        perm(0);
        System.out.println(ret);
    }

    public static void perm(int cnt) {
        if(cnt == N) {
            int sum = 0;
            for(int i = 1; i < N; i++)
                sum += (Math.abs(pick[i - 1] - pick[i]));
            ret = Math.max(ret, sum);
            return;
        }

        for(int i = 0; i < N; i++) {
            if(chk[i])
                continue;
            chk[i] = true;
            pick[cnt] = arr[i];
            perm(cnt + 1);
            chk[i] = false;
        }
    }
}
