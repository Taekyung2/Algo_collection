package boj;

import java.util.Arrays;
import java.util.Scanner;

/**
 * # 계획
 * 1. 사전순 출력이기 때문에 배열을 먼저 정렬시킨다.
 * 2. N개의 수에서 M개의 수를 골라 줄세우는 순열
 * 3. 중복되면 안되기 때문에 불린 배열에 중복 체크를 한다 (여기서는 비트로 중복 체크를 했음)
 * 4. 같은 수가 여러 개라면 같은 순열이 나올 수도 있기 때문에, 이전에 뽑은 수와 현재 뽑은 수가 같다면 continue
 *
 * # 시간 복잡도
 * O(N * M)
 */

public class Q15663 {
    static int N, M, visited = 0;
    static int[] arr, result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[N];
        result = new int[M];
        for(int i = 0; i < N; i++)
            arr[i] =  sc.nextInt();
        Arrays.sort(arr);
        perm(0);
    }

    public static void perm(int cnt) {
        if(cnt == M) {
            for(int a : result)
                System.out.print(a + " ");
            System.out.println();
            return;
        }

        int prev = -1;
        for(int next = 0; next < arr.length; next++) {
            if((visited & 1 << next) != 0 || prev == arr[next]) continue;

            visited |= (1 << next);
            prev = arr[next];
            result[cnt] = arr[next];
            perm(cnt + 1);
            visited &= ~(1 << next);
        }
    }
}
