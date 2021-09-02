package boj;

import java.io.*;
import java.util.*;

public class Q13549 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] dist = new int[100001];
        Arrays.fill(dist, -1);

        Queue<Integer> q = new LinkedList<>();
        q.add(N);
        dist[N] = 0;

        while(!q.isEmpty()) {
            int cur = q.poll();
            int[] nextArr = {cur * 2, cur - 1, cur + 1};

            for(int next : nextArr) {
                if(next < 0 || next > 100000) continue;
                if(dist[next] != -1) continue;
                if(next == cur * 2)
                    dist[next] = dist[cur];
                else
                    dist[next] = dist[cur] + 1;
                q.add(next);
            }
        }
        System.out.println(dist[K]);
    }
}

/**
 * 1. 2 * x의 위치로 순간이동 할 때는 시간을 소모하지 않기 때문에 bfs를 하면서 주의해야한다.
 * 2. bfs는 시작지점을 기준으로 가장 처음 발견한 것이 최단 거리라는 것을 이용해 진행하게 되는데,
 *    순간이동을 시간 소모없이 하게 되면 뒤에 들어온 값이 최단 거리가 될 수 있기 때문에
 *    다익스트라를 사용하거나 다른 방법보다 순간이동을 먼저 큐에 넣어준다.
 */