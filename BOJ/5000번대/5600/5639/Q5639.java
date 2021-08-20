package boj;

import java.io.*;
import java.util.*;

public class Q5639 {
    static List<Integer> pre = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        while((input = br.readLine()) != null) {
            pre.add(stoi(input));
        }

        postOrder(0, pre.size());
    }

    public static void postOrder(int s, int e) {
        if(s >= e)
            return;
        int cur = s + 1;
        while(cur < e && pre.get(s) > pre.get(cur))
            cur++;
        postOrder(s + 1, cur);
        postOrder(cur, e);
        System.out.println(pre.get(s));
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}

/**
 *  전위 순회 결과를 후위 순회로 바꾸기
 *  전위 : 50 / 30 24 5 28 45 / 98 52 60
 *  전위 순회는 루트 -> 왼쪽 -> 오른쪽 순서, 제일 처음 숫자가 루트가 된다
 *  루트의 값보다 큰 값이 나오기 전까지 왼쪽 서브 트리, 이후는 오른쪽 서브 트리 -> 재귀 반복
 *  후위 순회로 바꿔야 되기 때문에 오른쪽 서브트리 출력, 왼쪽 서브트리 출력, 루트 출력 순서로 호출
 */