package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q10989 {
    static int stoi(String s) { return Integer.parseInt(s);}
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = stoi(br.readLine());

        int[] num = new int[10001];
        for(int i = 0; i < N; i++)
            num[stoi(br.readLine())]++;

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < num.length; i++) {
            if(num[i] != 0) {
                for (int j = 0; j < num[i]; j++)
                    sb.append(i).append("\n");
            }
        }

        System.out.println(sb);
    }
}
