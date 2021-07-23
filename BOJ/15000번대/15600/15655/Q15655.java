package boj;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Q15655 {
    static int N, M;
    static int[] pick, num;
    static boolean[] chk;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        num = new int[N];

        for(int i = 0; i < N; i++)
            num[i] = sc.nextInt();
        Arrays.sort(num);
        pick = new int[M];
        chk = new boolean[N + 1];

        perm(0, 0);
        bw.flush();
    }

    public static void perm(int idx, int cnt) throws IOException {
        if(cnt == M) {
            for(int n : pick)
                bw.write(n + " ");
            bw.write("\n");
            return;
        }

        for(int i = idx; i < N; i++) {
            if(!chk[i]) {
                chk[i] = true;
                pick[cnt] = num[i];
                perm(i + 1, cnt + 1);
                chk[i] = false;
            }
        }
    }
}
