package boj;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Q15651 {
    static int N, M;
    static int[] pick;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        pick = new int[M];

        perm(  0);
        bw.flush();
    }

    public static void perm(int cnt) throws IOException {
        if(cnt == M) {
            for(int n : pick)
                bw.write(n + " ");
            bw.write("\n");
            return;
        }

        for(int i = 1; i <= N; i++) {
            pick[cnt] = i;
            perm(cnt + 1);
        }
    }
}
