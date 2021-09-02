package boj;

import java.io.*;
import java.util.*;

public class Q11000 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        List<int[]> time = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            time.add(new int[]{sc.nextInt(), 0});
            time.add(new int[]{sc.nextInt(), 1});
        }

        time.sort((t1, t2) -> {
            if(t1[0] == t2[0])
                return t2[1] - t1[1];
            return t1[0] - t2[0];
        });

        int cnt = 0, max = 0;
        for(var t : time) {
            if(t[1] == 0) {
                cnt++;
                max = Math.max(max, cnt);
            }
            else
                cnt--;
        }

        System.out.println(max);
    }
}

/**
 *  1. 시작하는 시간, 끝나는 시간을 시작인지 끝인지 표시 후 리스트에 저장
 *  2. 오름차순으로 정렬 후, 시작 시간이면 cnt++, 끝나는 시간이면 cnt--를 한다.
 *  3. 시작 시간과 종료 시간이 같으면 둘 다 할 수 있기 때문에, 시작하기 전에 종료 시간을 먼저 처리해주어야 한다.
 */