package boj;

import java.io.*;
import java.util.*;

public class Q11728 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = stoi(st.nextToken());
        int M = stoi(st.nextToken());

        int[] a = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] b = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int i = 0, j = 0;
        StringBuilder sb = new StringBuilder();
        while(i < N && j < M) {
            if(a[i] <= b[j]) sb.append(a[i++]).append(" ");
            else sb.append(b[j++]).append(" ");
        }

        while(i < N) sb.append(a[i++]).append(" ");
        while(j < M) sb.append(b[j++]).append(" ");

        System.out.println(sb);
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
