package boj;

/**
 *  1. 가장 높은 지점을 찾는다
 *  2. 왼쪽에서 가장 높은 지점에까지 계산
 *  3. 오른쪽에서 가장 높은 지점에까지 계산
 */

import java.util.Scanner;

public class Q2304 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] height = new int[1001];
        int mi = 0, mh = 0;
        for(int i = 0; i < N; i++) {
            int idx = sc.nextInt();
            int h = sc.nextInt();
            if(mh < h) {
                mi = idx;
                mh = h;
            }
            height[idx] = h;
        }

        int h = 0, ret = 0;
        for(int i = 0; i < mi; i++) {
            h = Math.max(height[i], h);
            ret += h;
        }
        h = 0;
        for(int i = 1000; i > mi; i--) {
            h = Math.max(height[i], h);
            ret += h;
        }

        System.out.println(ret + mh);
    }
}
