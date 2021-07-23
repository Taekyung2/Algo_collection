package boj;

import java.util.*;

public class Q2805 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long M = sc.nextLong();
        int[] arr = new int[N];
        for(int i = 0; i < N; i++)
            arr[i] = sc.nextInt();

        int lo = 0, hi = Integer.MAX_VALUE;

        while(lo <= hi) {
            int mid = (lo + hi) / 2;
            long sum = Arrays.stream(arr)
                        .mapToLong(Long::valueOf) // LongStream으로 변환
                        .map(n -> n - mid)
                        .filter(n -> n >= 0)
                        .sum();
            if(M <= sum)
                lo = mid + 1;
            else
                hi = mid - 1;
        }

        System.out.println(hi);
    }
}
