package boj;

/**
 *  가장 빠른 방법
 *      - 중간 지점에 가장 가까운 개미가 떨어지는 시간
 *
*   가장 느린 방법
 *      - 그냥 가장 먼 거리..?
 */

import java.io.*;
import java.util.StringTokenizer;

public class Q4307 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = stoi(br.readLine());
        while(tc-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int len = stoi(st.nextToken());
            int n = stoi(st.nextToken());
            int max = Integer.MIN_VALUE, min = Integer.MIN_VALUE;

            for(int i = 0; i < n; i++) {
                int p = stoi(br.readLine());
                max = Math.max(max, Math.max(len - p, p));
                min = Math.max(min, Math.min(len - p, p));
            }
            System.out.println(min + " " + max);
        }
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}