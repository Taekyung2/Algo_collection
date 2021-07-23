package boj;

import java.io.*;
import java.util.*;

public class Q2512 {
    static int N;
    static long M, arr[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = Arrays.stream(br.readLine()
                .split(" "))
                .mapToLong(Long::parseLong)
                .sorted()
                .toArray();
        M = Long.parseLong(br.readLine());

        if(Arrays.stream(arr).sum() <= M) {
            System.out.println(arr[N - 1]);
        } else {
            int lo = 0, hi = 100000;
            while (lo <= hi) {
                int mid = (lo + hi) / 2;
                if (isPossible(mid))
                    lo = mid + 1;
                else
                    hi = mid - 1;
            }
            System.out.println(hi);
        }
    }

    public static boolean isPossible(int n) {
        return M >= Arrays.stream(arr).map(x -> (x > n) ? n : x).sum();
    }
}
