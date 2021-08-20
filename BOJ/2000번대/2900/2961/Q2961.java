package boj;

import java.util.Scanner;

public class Q2961 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int ret = Integer.MAX_VALUE;
        Food[] arr = new Food[N];
        for(int i = 0; i < N; i++)
            arr[i] = new Food(sc.nextInt(), sc.nextInt());

        for(int i = 1; i < (1 << N); i++) {
            int sour = 1, bitter = 0;
            for(int j = 0; j < N; j++) {
                if((i & (1 << j)) != 0) {
                    sour *= arr[j].s;
                    bitter += arr[j].b;
                }
            }
            ret = Math.min(ret, Math.abs(sour - bitter));
        }
        System.out.println(ret);
    }

    static class Food {
        int s, b;
        Food(int s, int b) {
            this.s = s;
            this.b = b;
        }
    }
}

/**
 * 부분 집합을 구해서 신맛과 쓴맛을 구한 뒤 차이가 최소가 되는 값을 찾는다
 */
