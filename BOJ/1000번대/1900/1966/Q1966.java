package boj;

import java.util.LinkedList;
import java.util.Scanner;

public class Q1966 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        while(tc-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int cnt = 1;
            LinkedList<int[]> list = new LinkedList<>();

            for(int i = 0; i < n; i++)
                list.add(new int[] {i, sc.nextInt()});

            while(!list.isEmpty()) {
                int[] f = list.poll();
                if(list.stream().anyMatch(num -> f[1] < num[1])) {
                    list.add(f);
                } else {
                    if(f[0] == m)   System.out.println(cnt);
                    else            cnt++;
                }
            }
        }
    }
}
