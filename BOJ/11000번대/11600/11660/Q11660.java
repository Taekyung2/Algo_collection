package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q11660 {
    static int stoi(String s) { return Integer.parseInt(s); }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = stoi(st.nextToken());
        int M = stoi(st.nextToken());
        int[][] map = new int[N + 1][N + 1];
        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++)
                map[i][j] = stoi(st.nextToken());
        }

        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                map[i][j] += map[i - 1][j];
                map[i][j] += map[i][j - 1];
                map[i][j] -= map[i - 1][j - 1];
            }
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int y1 = stoi(st.nextToken());
            int x1 = stoi(st.nextToken());
            int y2 = stoi(st.nextToken());
            int x2 = stoi(st.nextToken());

            sb.append(map[y2][x2] - map[y2][x1 - 1] - map[y1 - 1][x2] + map[y1 - 1][x1 - 1]).append("\n");
        }
        System.out.println(sb);
    }
}
