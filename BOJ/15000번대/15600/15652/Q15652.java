package boj;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Q15652 {
    static int N, M;
    static int[] pick;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        pick = new int[M];

        perm(  1, 0);
        bw.flush();
    }

    public static void perm(int idx, int cnt) throws IOException {
        if(cnt == M) {
            for(int n : pick)
                bw.write(n + " ");
            bw.write("\n");
            return;
        }

        for(int i = idx; i <= N; i++) {
            pick[cnt] = i;
            perm(i, cnt + 1);
        }
    }
}
