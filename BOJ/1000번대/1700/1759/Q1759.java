package boj;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Q1759 {
    static int L, C;
    static HashSet<Character> moum = new HashSet<>();
    static Character[] arr, pick;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        L = sc.nextInt();
        C = sc.nextInt();
        moum.add('a');
        moum.add('e');
        moum.add('i');
        moum.add('o');
        moum.add('u');
        arr = new Character[C];
        pick = new Character[L];

        for(int i = 0; i < C; i++)
            arr[i] = sc.next().charAt(0);
        Arrays.sort(arr);
        doPick(0, 0);
    }

    public static void doPick(int idx, int cnt) {
        if(cnt == L) {
            // 모음, 자음 최소 개수 확인
            int moCnt = (int) Arrays.stream(pick)
                    .filter(c -> moum.contains(c))
                    .count();
            if(moCnt >= 1 && L - moCnt >= 2) {
                Arrays.stream(pick).forEach(System.out::print);
                System.out.println();
            }
            return;
        }

        for(int i = idx; i < C; i++) {
            pick[cnt] = arr[i];
            doPick(i + 1, cnt + 1);
        }
    }
}

/**
 *  # 계획
 *  1. 최소 모음이 한 개, 자음이 두 개
 *  2. 정렬된 순서대로 나열
 */