package boj;

import java.io.*;
import java.util.Arrays;

public class Q2491 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int p = 0, ret = 1, up = 1, down = 1;

        while(p < N - 1) {
            if(arr[p] < arr[p + 1]) {
                down++;
                up = 1;
            } else if(arr[p] > arr[p + 1]) {
                up++;
                down = 1;
            } else {
                up++;
                down++;
            }
            ret = Math.max(ret, up);
            ret = Math.max(ret, down);
            p++;
        }

        System.out.println(ret);
    }
}
