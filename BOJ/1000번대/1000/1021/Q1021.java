package boj;

import java.util.LinkedList;
import java.util.Scanner;

public class Q1021 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int ret = 0;

        LinkedList<Integer> list = new LinkedList<>();
        for(int i = 1; i <= N; i++)
            list.add(i);

        for(int i = 0; i < M; i++) {
            int cur = sc.nextInt();
            int position = list.indexOf(cur);
            if(position < list.size() - position) {
                for(int j = 0; j < position; j++)
                    list.addLast(list.pollFirst());
                ret += position;
            } else {
                for(int j = 0; j < list.size() - position; j++)
                    list.addFirst(list.pollLast());
                ret += list.size() - position;
            }

            list.remove(0);
        }

        System.out.println(ret);
    }
}
