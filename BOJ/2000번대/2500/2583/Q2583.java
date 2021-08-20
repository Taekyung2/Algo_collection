package boj;

import java.awt.*;
import java.util.*;

public class Q2583 {
    static int M, N, K;
    static int[] dy = {-1, 0, 1, 0}, dx = {0, 1, 0, -1};
    static int[][] map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        N = sc.nextInt();
        K = sc.nextInt();
        map = new int[M][N];
        for(int i = 0; i < K; i++) {
            int sx = sc.nextInt(), sy = sc.nextInt(), ex = sc.nextInt(), ey = sc.nextInt();
            for(int y = sy; y < ey; y++)
                for(int x = sx; x < ex; x++)
                    map[y][x] = 1;
        }
        ArrayList<Integer> ret = new ArrayList<>();
        for(int i = 0; i < M; i++)
            for(int j = 0; j < N; j++)
                if(map[i][j] == 0) {
                    map[i][j] = 1;
                    ret.add(bfs(new Point(j, i)));
                }

        Collections.sort(ret);
        System.out.println(ret.size());
        ret.forEach(x -> System.out.print(x + " "));
    }

    static int bfs(Point p) {
        Queue<Point> q = new LinkedList<>();
        q.add(p);
        int cnt = 0;
        while(!q.isEmpty()) {
            Point cur = q.poll();
            cnt++;
            for(int d = 0; d < 4; d++) {
                int ny = cur.y + dy[d], nx = cur.x + dx[d];
                if(ny < 0 || nx < 0 || ny >= M || nx >= N || map[ny][nx] != 0) continue;
                map[ny][nx] = 1;
                q.add(new Point(nx, ny));
            }
        }
        return cnt;
    }
}

/** # 계획
 *  1. 직사각형 영역 체크 해놓기
 *  2. 직사각형 영역이 아닌 경우 dfs or bfs, 결과 리스트에 저장
 *  3. 정렬 후 출
 */