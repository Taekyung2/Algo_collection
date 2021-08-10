package boj;

import java.util.LinkedList;
import java.util.Scanner;

/**
 *  # 계획
 *  1. 만약 N = 5, K = 6
 *  2. [1, 2, 3, 4, 5] -> 맨 뒤를 앞으로 보내면 [5, 1, 2, 3, 4] : 그렇고 그런 사이 4
 *  3. 다시 맨 뒤를 한 칸 앞으로, -> [5, 1, 4, 2, 3] : 그렇고 그런 사이 6
 */

public class Q20921 {
    static int N, K;
    static LinkedList<Integer> list = new LinkedList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        for (int i = 0; i < N; i++) list.add(i + 1);
        int cnt = N - 1;
        while(cnt > 0 && K > 0) {
            if(K < cnt) cnt = K;
            int point = N - cnt - 1;
            list.add(point, list.pollLast());
            K -= cnt;
            cnt--;
        }
        for(int n : list)
            System.out.print(n + " ");
    }
}
