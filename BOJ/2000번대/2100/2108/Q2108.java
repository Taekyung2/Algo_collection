package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q2108 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = stoi(br.readLine());
        int[] arr = new int[N];
        int[] cnt = new int[8001];
        int sum = 0, max = 0;
        List<Integer> list = new ArrayList<>();


        for(int i = 0; i < N; i++) {
            arr[i] = stoi(br.readLine());
            sum += arr[i];
            cnt[arr[i] + 4000]++;
        }

        for(int i = 0; i <= 8000; i++)
            max = Math.max(max, cnt[i]);
        for(int i = 0; i <= 8000; i++)
            if(max == cnt[i])
                list.add(i - 4000);

        Arrays.sort(arr);
        System.out.println((int)Math.round((double)sum / N));
        System.out.println(arr[N / 2]);
        System.out.println(list.size() > 1 ? list.get(1) : list.get(0));
        System.out.println(arr[N - 1] - arr[0]);
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
