package boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q7562 {
    static int l;
    static Point S, E;
    static int[][] discovered;
    static int[] dy = {2, 1, -1, -2, -2, -1, 1, 2};
    static int[] dx = {1, 2, 2, 1, -1, -2, -2, -1};

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        while(tc-- > 0) {
            l = sc.nextInt();
            S = new Point(sc.nextInt(), sc.nextInt());
            E = new Point(sc.nextInt(), sc.nextInt());
            discovered = new int[l][l];

            Queue<Point> q = new LinkedList<>();
            q.add(S);
            discovered[S.y][S.x] = 0;

            while(!q.isEmpty()) {
                Point cur = q.poll();
                if(cur.y == E.y && cur.x == E.x) {
                    System.out.println(discovered[E.y][E.x]);
                    break;
                }

                for(int d = 0; d < 8; d++) {
                    int ny = cur.y + dy[d];
                    int nx = cur.x + dx[d];
                    if(ny < 0 || nx < 0 || ny >= l || nx >= l || discovered[ny][nx] != 0)
                        continue;
                    discovered[ny][nx] = discovered[cur.y][cur.x] + 1;
                    q.add(new Point(ny, nx));
                }
            }
        }
    }

    static class Point {
        int y, x;
        Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
