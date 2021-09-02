package boj;

import java.io.*;
import java.util.*;

public class Q12851 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] dist = new int[100001];

        Queue<Integer> q = new LinkedList<>();
        q.add(N);
        int ret = 0, cnt = 0;
        while(cnt == 0) {
            int s = q.size();
            for(int c = 0; c < s; c++) {
                int cur = q.poll();
                if(cur == K)
                    cnt++;

                int[] nextArr = {cur - 1, cur + 1, cur * 2};

                for(int next : nextArr) {
                    if(next < 0 || next > 100000) continue;
                    if(dist[next] != 0 && dist[next] == dist[cur] + 1)
                        continue;
                    q.add(next);
                    dist[next] = dist[cur] + 1;
                }
            }
            ret++;
        }
        System.out.println(ret - 1);
        System.out.println(cnt);
    }
}

/**
 *  1. 이동할 수 있는 3가지 방법으로 bfs 탐색을 시도한다.
 *  2. bfs 도중 동생의 위치를 찾았을 때, 현재 시도 중인 횟수가 끝날 때 까지 동생을 찾는 다른 방법이 있다면 카운트
 *  3. 갈 수 있는 다음 수를 찾을 때마다 visit 배열을 체크하면, 최단 시간 방법의 경우의 수가 줄어들기 때문에, 저장해놨다가 한꺼번에 갱신
 */