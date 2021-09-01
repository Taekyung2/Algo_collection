package boj;

import java.io.*;
import java.util.*;

public class Q6593 {
    static char[][][] map;
    static int[][][] dist;
    static int[] dz = {0, 0, 0, 0, 1, -1};
    static int[] dy = {1, 0, -1, 0, 0, 0};
    static int[] dx = {0, 1, 0, -1, 0, 0};
    static int L, R, C;
    static Point S, E;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(true) {
            L = sc.nextInt();
            R = sc.nextInt();
            C = sc.nextInt();
            if(L == 0 && R == 0 && C == 0)
                break;
            map = new char[L][R][C];
            dist = new int[L][R][C];

            for (int i = 0; i < L; i++) {
                for (int j = 0; j < R; j++) {
                    String s = sc.next();
                    for (int k = 0; k < C; k++) {
                        char c = s.charAt(k);
                        map[i][j][k] = c;
                        if(c == 'S')
                            S = new Point(i, j, k);
                        if(c == 'E')
                            E = new Point(i, j, k);
                    }
                }
                sc.nextLine();
            }

            Queue<Point> q = new LinkedList<>();
            q.add(S);
            dist[S.z][S.y][S.x] = 1;
            while(!q.isEmpty()) {
                Point cur = q.poll();
                if(map[cur.z][cur.y][cur.x] == 'E')
                    break;
                for(int d = 0; d < 6; d++) {
                    int nz = cur.z + dz[d];
                    int ny = cur.y + dy[d];
                    int nx = cur.x + dx[d];
                    if(nz < 0 || ny < 0 || nx < 0 || nz >= L || ny >= R || nx >= C ||
                            map[nz][ny][nx] == '#' || dist[nz][ny][nx] != 0)
                        continue;
                    dist[nz][ny][nx] = dist[cur.z][cur.y][cur.x] + 1;
                    q.add(new Point(nz, ny, nx));
                }
            }

            if(dist[E.z][E.y][E.x] == 0)
                System.out.println("Trapped!");
            else
                System.out.printf("Escaped in %d minute(s).%n", dist[E.z][E.y][E.x] - 1);
        }
    }

    static class Point {
        int z, y, x;

        Point(int z, int y, int x) {
            this.z = z;
            this.y = y;
            this.x = x;
        }
    }
}

/**
 * 단순 bfs면 풀릴 것 같은데
 */