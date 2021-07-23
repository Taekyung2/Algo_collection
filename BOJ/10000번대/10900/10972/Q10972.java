package boj;

import java.util.Scanner;

public class Q10972 {
    static int N;
    static int[] arr;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N];

        for(int i = 0; i < N; i++)
            arr[i] = sc.nextInt();

        if(nextPermutation()) {
            for(int n : arr)
                System.out.print(n + " ");
        } else
            System.out.println(-1);
    }

    public static boolean nextPermutation() {
        // 오른쪽에서 왼쪽으로 가장 큰 지점
        int i = N - 1;
        while(i > 0 && arr[i - 1] >= arr[i])
            --i;
        // 내림차순으로 정렬 되있으면 마지막 순열
        if(i == 0)
            return false;

        // arr[i - 1] : 왼쪽 부분에서 바꿀 값
        // arr[i - 1]보다 작은 값을 오른쪽에서 찾는다
        int j = N - 1;
        while(arr[i - 1] >= arr[j])
            --j;

        // swap
        int tmp = arr[i - 1];
        arr[i - 1] = arr[j];
        arr[j] = tmp;

        // 오른쪽 부분이 내림차순으로 되어있으므로, 오름차순으로 변경
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
