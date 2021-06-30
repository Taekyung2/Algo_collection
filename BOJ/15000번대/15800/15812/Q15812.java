import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q15812 {
    static int N, M, town = 0;
    static char[][] map;
    static int[] dy = {-1, 0, 1, 0}, dx = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        map = new char[N][M];
        for(int i = 0; i < N; i++) {
            String s = sc.next();
            for(int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j);
                if(map[i][j] == '1')
                    town++;
            }
        }
        int ret = Integer.MAX_VALUE;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(map[i][j] == '1') continue;
                for(int ii = i; ii < N; ii++) {
                    for(int jj = (ii == i ? j + 1 : 0); jj < M; jj++) {
                        if(map[ii][jj] == '1') continue;
                        ret = Math.min(ret, bfs(i, j, ii, jj));
                    }
                }
            }
        }
        System.out.println(ret + 1);
    }

    public static int bfs(int y, int x, int yy, int xx) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];
        q.add(new int[]{y, x});
        q.add(new int[]{yy, xx});
        visited[y][x] = true;
        visited[yy][xx] = true;
        int cnt = 0, time = 0;

        while(!q.isEmpty()) {
            for (int s = 0; s < q.size(); s++) {
                int[] cur = q.poll();
                if (map[cur[0]][cur[1]] == '1') {
                    cnt++;
                }
                if(cnt == town) return time;
                for (int d = 0; d < 4; d++) {
                    int ny = cur[0] + dy[d], nx = cur[1] + dx[d];
                    if (ny < 0 || nx < 0 || ny >= N || nx >= M || visited[ny][nx])
                        continue;
                    visited[ny][nx] = true;
                    q.add(new int[]{ny, nx});
                }
            }
            time++;
        }
        return Integer.MAX_VALUE;
    }
}
