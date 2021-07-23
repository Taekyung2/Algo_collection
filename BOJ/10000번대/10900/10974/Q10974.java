package boj;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Q10974 {
    static int N;
    static int[] arr;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = IntStream.rangeClosed(1, N).toArray();
        StringBuilder sb = new StringBuilder();
        do {
            for(int n : arr)
                sb.append(n + " ");
            sb.append("\n");
        } while(nextPermutation());
        System.out.println(sb);
    }

    private static boolean nextPermutation() {
        int i = N - 1;
        while(i > 0 && arr[i - 1] >= arr[i])
            i--;
        if(i == 0)
            return false;

        int j = N - 1;
        while(arr[i - 1] >= arr[j])
            j--;

        int tmp = arr[j];
        arr[j] = arr[i - 1];
        arr[i - 1] = tmp;

        int k = N - 1;
        while(i < k) {
            tmp = arr[i];
            arr[i] = arr[k];
            arr[k] = tmp;
            i++;
            k--;
        }
        return true;
    }
}
