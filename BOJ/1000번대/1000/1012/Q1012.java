import java.util.*;

public class Q1012 {
    static int N, M, K;
    static boolean[][] map;
    static int[] dy = {-1, 0, 1, 0}, dx = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        while(tc-- > 0) {
            M = sc.nextInt();
            N = sc.nextInt();
            K = sc.nextInt();
            map = new boolean[N][M];
            int ret = 0;

            for(int i = 0; i < K; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                map[y][x] = true;
            }

            for(int y = 0; y < N; y++)
                for(int x = 0; x < M; x++)
                    if(map[y][x]) {
                        bfs(y, x);
                        ret++;
                    }
            System.out.println(ret);
        }
    }

    public static void bfs(int y, int x) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{y, x});
        map[y][x] = false;

        while(!q.isEmpty()) {
            int[] cur = q.poll();

            for(int d = 0; d < 4; d++) {
                int ny = cur[0] + dy[d];
                int nx = cur[1] + dx[d];
                if(ny >= 0 && nx >= 0 && ny < N && nx < M && map[ny][nx]) {
                    q.add(new int[]{ny, nx});
                    map[ny][nx] = false;
                }
            }
        }
    }
}