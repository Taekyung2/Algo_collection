package boj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

/**
 * # 계획
 * 1. 비내림차순이므로, 배열을 미리 정렬하자
 * 2. 같은 수를 여러 번 골라도 되기 때문에, 중복 체크는 필요 없음.
 * 3. 같은 수가 여러 개 있어서 같은 순열이 나올 경우가 있기 때문에 처리 필요
 *
 * # 시간 복잡도
 * O(N * M)
 *
 */

public class Q15666 {
    static int N, M;
    static HashSet<Integer> s = new HashSet<>();
    static int[] pick;
    static ArrayList<Integer> list;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        pick = new int[M];
        for(int i = 0; i < N; i++)
            s.add(sc.nextInt());
        list = new ArrayList<>(s);
        Collections.sort(list);
        perm(0, 0);
    }

    static void perm(int idx, int cnt) {
        if(cnt == M) {
            for(int n : pick)
                System.out.print(n + " ");
            System.out.println();
            return;
        }
        for(int i = idx; i < list.size(); i++) {
            pick[cnt] = list.get(i);
            perm(i, cnt + 1);
        }
    }
}
