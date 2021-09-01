package boj;


import java.io.*;
import java.util.*;

public class Q9019 {
    static char[] ops = {'D', 'S', 'L', 'R'};
    static int[][] choice;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while(T-- > 0) {
            int A = sc.nextInt();
            int B = sc.nextInt();
            choice = new int[10000][2];
            boolean[] visited = new boolean[10000];

            Queue<Integer> q = new LinkedList<>();
            q.add(A);
            visited[A] = true;
            choice[A][0] = -1;

            while(!q.isEmpty()) {
                int cur = q.poll();
                if(cur == B)
                    break;

                int[] nextArr = {D(cur), S(cur), L(cur), R(cur)};
                for(int idx = 0; idx < nextArr.length; idx++) {
                    int next = nextArr[idx];
                    if(!visited[next]) {
                        visited[next] = true;
                        q.add(next);
                        choice[next][0] = cur;
                        choice[next][1] = idx;
                    }
                }
            }
            System.out.println(reconstruct(B, new StringBuilder()).reverse());
        }
    }

    static StringBuilder reconstruct(int cur, StringBuilder sb) {
        if(choice[cur][0] == -1)
            return sb;
        return reconstruct(choice[cur][0], sb.append(ops[choice[cur][1]]));
    }

    static int D(int number) {
        return (number * 2) % 10000;
    }

    static int S(int number) {
        return number == 0 ? 9999 : number - 1;
    }

    static int L(int number) {
        return ((number % 1000) * 10) + (number / 1000);
    }

    static int R(int number) {
        return ((number % 10) * 1000) + (number / 10);
    }
}

/**
 *  각각의 상태에서 D, S, L, R 네 가지의 연산을 하는 것으로 BFS를 실행하자
 *  명령어를 출력해야 하기 때문에, 각각의 단계에서 골랐던 명령어를 저장해 놓아야 겠다.
 */