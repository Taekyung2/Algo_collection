package common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Regex_Test {
    static int[][] dt = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
    static int HOLE = -1;
    static int N, M;
    static int result;

    public static int[] inputToIntArr(String str, String separator) {
        return Arrays.stream(str.split(separator)).mapToInt(Integer::parseInt).toArray();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = inputToIntArr(br.readLine(), " ");
        N = input[0];
        M = input[1];

        int[][] move = new int[N][M];
        for (int[] m : move) {
            String[] str = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                m[j] = str[j].equals("H") ? HOLE : Integer.parseInt(str[j]); // 구멍인 경우 -1 저장
            }
        }
        result = 0;
        dfs(move, new boolean[N][M], new int[N][M], new Node(0, 0, 0));
        System.out.println(result);

    }

    static void dfs(int[][] move, boolean[][] visited, int[][] dp, Node cur) {
        for (int d = 0; d < 4; d++) {
            int r = cur.r + dt[d][0] * move[cur.r][cur.c];
            int c = cur.c + dt[d][1] * move[cur.r][cur.c];
            if (r < 0 || c < 0 || r >= N || c >= M || move[r][c] == HOLE) { // 게임 끝 조건
                result = Math.max(cur.cnt + 1, result);
                continue;
            }
            if (visited[r][c]) { // 방문한 곳 또 방문하면, 사이클 발생 (무한)
                System.out.println(-1);
                System.exit(0);
            }
            if (dp[r][c] >= cur.cnt + 1)
                continue; // 전에 탐색했던 곳 방문 -> 현재 cnt가 더 적으면 pass

            dp[r][c] = cur.cnt + 1;
            visited[r][c] = true;
            dfs(move, visited, dp, new Node(r, c, cur.cnt + 1)); // 다음 지점으로 이동
            visited[r][c] = false;
        }
    }

    static class Node {
        int r, c;
        int cnt;

        public Node(int r, int c, int cnt) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }

    }

}