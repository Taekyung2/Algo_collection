package boj;

import java.io.*;
import java.util.*;

public class Q10216 {
    static int N;
    static List<Integer>[] adj;
    static Enemy[] enemies;
    static boolean[] check;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        // tc번 반복
        while(tc-- > 0) {
            N = sc.nextInt();
            adj = new List[N];
            enemies = new Enemy[N];
            check = new boolean[N];
            int ret = 0;

            for(int idx = 0; idx < N; idx++)
                adj[idx] = new ArrayList<>();

            for(int idx = 0; idx < N; idx++)
                enemies[idx] = new Enemy(sc.nextInt(), sc.nextInt(), sc.nextInt());

            // 그래프 생성
            for(int i = 0; i < N - 1; i++)
                for(int j = i + 1; j < N; j++)
                    if(enemies[i].isCommunication(enemies[j])) {
                        adj[i].add(j);
                        adj[j].add(i);
                    }

            for(int i = 0; i < N; i++) {
                if(!check[i]) {
                    dfs(i);
                    ret++;
                }
            }

            System.out.println(ret);
        }
    }

    public static void dfs(int cur) {
        check[cur] = true;

        for(int next : adj[cur]) {
            if(!check[next]) {
                dfs(next);
            }
        }
    }

    static class Enemy {
        int x, y, r;

        Enemy(int x, int y, int r) {
            this.x = x;
            this.y = y;
            this.r = r;
        }

        boolean isCommunication(Enemy e) {
            return Math.pow(this.r + e.r, 2) >= Math.pow(this.y - e.y, 2) + Math.pow(this.x - e.x, 2);
        }
    }
}

/**
 *  1. 적군의 좌표를 가지고 그래프를 만들어서, 모든 적군을 순회하면서 그래프 탐색이 몇번 일어나는지 카운트하는 방법
 *  2. 유니온 - 파인드 자료구조를 만들어서, 루트의 개수를 세는 방법
 */