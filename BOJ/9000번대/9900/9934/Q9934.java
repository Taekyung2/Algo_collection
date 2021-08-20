package boj;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q9934 {
    static int K;
    static int[] order;
    static List<Integer>[] ret;

    @SuppressWarnings("unchecked")
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();
        int len = (int) Math.pow(2, K) - 1;
        order = new int[len];
        ret = new ArrayList[K];
        for(int i = 0; i < K; i++)
            ret[i] = new ArrayList<>();

        for(int i = 0; i < len; i++)
            order[i] = sc.nextInt();

        inOrder(0, len - 1, 0);
        for(var list : ret) {
            list.forEach(n -> System.out.print(n + " "));
            System.out.println();
        }
    }

    public static void inOrder(int s, int e, int level) {
        if(s > e)
            return;
        int root = (s + e) / 2;
        inOrder(s, root - 1, level + 1);
        inOrder(root + 1, e, level + 1);
        ret[level].add(order[root]);
    }
}

/**
 * 중위 순회 순서를 가지고 각 레벨당 노트 출력하기
 *  1 6 4 / 3 / 5 2 7
 *  inOrder(start, end, level) -> 중간 값을 list.get(level) 안에다가 저장, 왼쪽 트리 호출(inOrder(start, root, level + 1), 오른쪽 트리 호출
 */
