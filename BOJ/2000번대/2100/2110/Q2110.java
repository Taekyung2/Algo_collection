package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q2110 {
    static int N, C;
    static int[] house;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = stoi(st.nextToken());
        C = stoi(st.nextToken());
        house = new int[N];
        for(int i = 0; i < N; i++) {
            house[i] = stoi(br.readLine());
        }

        // 이분탐색을 위해 정렬
        Arrays.sort(house);

        // 가능한 거리 탐색을 위해 이분 탐색
        int lo = 1, hi = house[N - 1] - house[0];
        while(lo <= hi) {
            int mid = (lo + hi) / 2;
            if(isPossible(mid)) {
                lo = mid + 1;
            } else
                hi = mid - 1;
        }
        System.out.println(hi);
    }

    static boolean isPossible(int distance) {
        int cnt = 1, prev = house[0];
        for(int i = 1; i < N; i++) {
            if(house[i] - prev >= distance) {
                cnt++;
                prev = house[i];
            }
        }
        return cnt >= C;
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
