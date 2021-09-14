package boj;

import java.io.*;
import java.util.*;

public class Q22942 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = stoi(br.readLine());
        List<int[]> list = new ArrayList<>();
        while(N-- > 0) {
            String s = br.readLine();
            int x = stoi(s.split(" ")[0]);
            int r = stoi(s.split(" ")[1]);
            list.add(new int[]{x - r, x + r});
        }

        list.sort((c1, c2) -> {
            if(c1[0] != c2[0]) return c1[0] - c2[0];
            return c1[1] - c2[1];
        });

        boolean ret = true;
        int[] prev = new int[]{-(int)1e9, -(int)1e9};
        for(int[] c : list) {
            if(prev[1] >= c[0] && prev[1] <= c[1]) {
                ret = false;
                break;
            }
            prev = c;
        }

        System.out.println(ret ? "YES" : "NO");
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}

/**
 * (x - r, x + r)
 * 왼쪽 좌표 기준으로 정렬 후, 이전 원이랑 포함관계이거나 아예 안겹치는지 확인
 */