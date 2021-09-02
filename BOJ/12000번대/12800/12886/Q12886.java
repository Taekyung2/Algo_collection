package boj;

import java.io.*;
import java.util.*;

public class Q12886 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] start = new int[3];
        // 숫자 2개를 알면 한개는 자동으로 정해지기 때문에 2개만 저장
        boolean[][] visited = new boolean[1501][1501];
        int sum = 0;
        for(int i = 0; i < 3; i++) {
            start[i] = sc.nextInt();
            sum += start[i];
        }

        if(sum % 3 != 0) {
            System.out.println(0);
            return;
        }

        int target = sum / 3;
        Arrays.sort(start);

        Queue<int[]> q = new LinkedList<>();
        visited[start[0]][start[1]] = true;
        q.add(start);

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            for(int i = 0; i < 2; i++) {
                for(int j = i + 1; j < 3; j++) {
                    int[] tmp = cur.clone();
                    tmp[i] *= 2;
                    tmp[j] -= cur[i];
                    Arrays.sort(tmp); // 순서를 통일시키기 위해 정렬
                    if(!visited[tmp[0]][tmp[1]]) {
                        visited[tmp[0]][tmp[1]] = true;
                        q.add(tmp);
                    }
                }
            }
        }
        System.out.println((visited[target][target]) ? 1 : 0);
    }
}

/**
 * 1. 세 그룹의 돌 총합이 3등분이 안되면 false
 * 2. 10, 15, 35 -> 20, 20, 20으로 만들어야 됨
 *      - 세 개 중에 2개 고르기 ( 크기가 같지 않은 것으로 )
 *      - 고른 돌을 연산해서 3크기 배열로 bfs
 *      - 20, 20, 20이 나오면 성공, 안나오면 실패
 */