package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q10815 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = stoi(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] a = new int[N];
        for(int i = 0; i < N; i++)
            a[i] = stoi(st.nextToken());

        Arrays.sort(a);
        StringBuilder sb = new StringBuilder();

        int M = stoi(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++) {
            int n = stoi(st.nextToken());
            if(Arrays.binarySearch(a, n) >= 0)
                sb.append(1);
            else
                sb.append(0);
            sb.append(" ");
        }

        System.out.println(sb);
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
