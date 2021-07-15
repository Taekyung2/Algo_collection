package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q10816 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = stoi(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] a = new int[20000001];
        for(int i = 0; i < N; i++)
            a[stoi(st.nextToken()) + 10000000]++;
        StringBuilder sb = new StringBuilder();

        int M = stoi(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++)
            sb.append(a[stoi(st.nextToken()) + 10000000]).append(" ");
        System.out.println(sb);
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
