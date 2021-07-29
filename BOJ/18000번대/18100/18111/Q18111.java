package boj;

import java.io.*;
import java.util.StringTokenizer;

public class Q18111 {
    static int N, M, B, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
    static int ret, time = Integer.MAX_VALUE;
    static int[] height = new int[257];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int n = Integer.parseInt(st.nextToken());
                max = Math.max(max, n);
                min = Math.min(min, n);
                height[n]++;
            }
        }

        for(int n = max; n >= min; n--) {
            // 모든 칸을 n 높이로 땅고르기
            int inven = B, t = 0;
            for(int i = max; i > n; i--) {
                inven += height[i] * (i - n);
                t += 2 * height[i] * (i - n);
            }
            for(int i = min; i < n; i++) {
                inven -= height[i] * (n - i);
                t += height[i] * (n - i);
            }

            if(inven >= 0 && time > t) {
                ret = n;
                time = t;
            }
        }

        System.out.println(time + " " + ret);
    }
}
