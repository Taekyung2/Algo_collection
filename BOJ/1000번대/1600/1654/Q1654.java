package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 정리
public class Q1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[K];
        int len = 0;
        for(int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            len = Math.max(len, arr[i]);
        }

        long lo = 1, hi = len;
        while(lo <= hi) {
            int sum = 0;
            long mid = (lo + hi) / 2;
            for(int i = 0; i < K; i++)
                sum += arr[i] / mid;
            if(sum >= N) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        System.out.println(hi);
    }
}
