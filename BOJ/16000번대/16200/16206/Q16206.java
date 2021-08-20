package boj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Q16206 {
    static int N, M, ret = 0;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        ArrayList<Integer> n1 = new ArrayList<>();
        ArrayList<Integer> n2 = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            int n = sc.nextInt();
            if(n == 10)
                ret++;
            else if(n % 10 == 0)
                n1.add(n);
            else
                n2.add(n);
        }

        Collections.sort(n1);
        Collections.sort(n2);
        solve(n1, 1);
        solve(n2, 0);
        System.out.println(ret);
    }

    public static void solve(ArrayList<Integer> list, int type) {
        for(int n : list) {
            if(M >= (n / 10) - type) {
                ret += n / 10;
                M -= n / 10 - type;
            } else {
                ret += M;
                M = 0;
            }
            if(M == 0)
                return;
        }
    }
}
