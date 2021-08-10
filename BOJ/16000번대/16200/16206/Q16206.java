package boj;

/**
 *  # 계획
 *  1. 만약 처음부터 10이라면 카운트
 *  2. 10의 배수일 때
 *      - 20 -> 1번 자르면 2개
 *      - 30 -> 2번 자르면 3개
 *      -> 10의 배수 중 작은거 부터 잘라나가는게 유리하겠다.
 *   3. 10의 배수가 아닐 때
 *      - 자르는 횟수 만큼 카운트
 */

import java.util.*;

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
