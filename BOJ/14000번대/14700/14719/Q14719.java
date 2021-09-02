package boj;

import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Q14719 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.nextInt();
        int w = sc.nextInt();
        List<Integer> map = new ArrayList<>(w);
        for(int i = 0; i < w; i++)
            map.add(sc.nextInt());
        int ret = 0;

        for(int i = 1; i < w; i++) {
            int l = max(map.subList(0, i));
            int r = max(map.subList(i + 1, w));
            int d = Math.min(l, r) - map.get(i);
            if(d > 0)
                ret += d;
        }
        System.out.println(ret);
    }

    static int max(List<Integer> list) {
        return list.stream().max(Integer::compareTo).orElse(0);
    }
}

/**
 * 1. 0부터 W까지 옆으로 이동하면서, 현재 자신의 칸을 기준으로 좌우로 나눕니다
 * 2. 왼쪽 부분에서 가장 높은 부분과, 오른쪽 부분에서 가장 높은 부분 사이에 빗물이 고이기 때문에
 *      양 옆중 낮은 부분과 현재 자신의 높이의 차이만큼 빗물이 고이게 됩니다.
 */