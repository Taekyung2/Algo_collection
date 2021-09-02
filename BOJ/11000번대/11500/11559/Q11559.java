package boj;

import java.io.*;
import java.util.*;

public class Q11559 {
    static boolean[][] visited;
    static char[][] board;
    static ArrayList<Point> list = new ArrayList<>();
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        board = new char[12][6];
        for(int i = 0; i < 12; i++)
            board[i] = sc.nextLine().toCharArray();
        
        int cnt = 0;
        while(true) {
            visited= new boolean[12][6];
            for(int i = 0; i < 12; i++)
                for(int j = 0; j < 6; j++)
                    if(board[i][j] != '.' && !visited[i][j])
                        bfs(new Point(i, j));

            if(list.size() == 0) break;
            else {
                cnt++;
                for (Point Point : list)
                    board[Point.y][Point.x] = '.';
                list.clear();
                down();
            }
        }
        System.out.println(cnt);
    }

    public static void bfs(Point curr_p) {
        Queue<Point> q = new LinkedList<>();
        ArrayList<Point> list2 = new ArrayList<>();
        q.add(curr_p);
        list2.add(curr_p);
        visited[curr_p.y][curr_p.x] = true;
        while(!q.isEmpty()) {
            Point now = q.poll();
            for(int d = 0; d < 4; d++) {
                Point next = new Point(now.y + dy[d], now.x + dx[d]);
                if(next.y < 0 || next.x < 0 || next.y >= 12 || next.x >= 6 ||
                        visited[next.y][next.x] || board[next.y][next.x] != board[now.y][now.x]) continue;
                visited[next.y][next.x] = true;
                q.add(next);
                list2.add(next);
            }
        }

        if(list2.size() >= 4)
            list.addAll(list2);
    }

    public static void down() {
        for(int i = 0; i < 6; i++)
            for(int j = 10; j >= 0; j--)
                for(int k = 11; k > j; k--)
                    if(board[j][i] != '.' && board[k][i] == '.') {
                        board[k][i] = board[j][i];
                        board[j][i] = '.';
                        break;
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

/**
 *  1. 모든 칸을 순회하면서 bfs로 4개 이상이 모여 있는 것을 찾습니다.
 *  2. 다 찾은 다음에 한번에 터뜨려야 하기 때문에, 별도의 공간에 저장해놓습니다
 *  3. 모든 칸 순회가 끝나고, 저장해놓았던 뿌요를 터뜨립니다.
 *  4. 뿡 밑에 빈칸이 있다면 밑으로 내립니다.
 */