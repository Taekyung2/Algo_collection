package boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 *  #계획
 *  bfs로 X - 1, X + 1, 2 * X의 경우를 탐색
 *  최단 경로로 K를 갈 수 있는 방법 서치
 */

public class Q1697 {
    static class Point {
        int x, time;

        Point(int x, int time) {
            this.x = x;
            this.time = time;
        }
    }
    static int n, k;
    static boolean[] visited = new boolean[100001];


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        System.out.println(bfs());
    }


    public static int bfs() {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(n, 0));
        visited[n] = true;
        while(!q.isEmpty()) {
            Point cur = q.poll();
            if(cur.x == k) return cur.time;
            int[] arr = new int[]{cur.x - 1, cur.x + 1, cur.x * 2};
            for(var next : arr) {
                if(next >= 0 && next <= 100000 && !visited[next]) {
                    q.add(new Point(next, cur.time + 1));
                    visited[next] = true;
                }
            }
        }
        return -1;
    }
}
