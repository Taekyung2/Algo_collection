package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q2470 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        // 오름차순 정렬
        Arrays.sort(arr);

        // 투포인터
        int p1 = 0, p2 = N - 1;
        int min = Integer.MAX_VALUE;
        int[] ret = new int[2];

        while(p1 < p2) {
            int sum = arr[p1] + arr[p2];
            if(Math.abs(sum) < min) {
                min = Math.abs(sum);
                ret[0] = arr[p1];
                ret[1] = arr[p2];
            } else {
                if(sum < 0)
                    p1++;
                else
                    p2--;
            }
        }
        System.out.println(ret[0] + " " + ret[1]);
    }
}

/**
 *  #계획
 *  1. 두 용액을 혼합하여 0에 가장 가까운 용액을 만들기
 *  2. N이 10만개, nlogN은 가능할 듯(정렬은 가능)
 *  3. 정렬한 후, 투포인터나 이분탐색을 진행
 */
