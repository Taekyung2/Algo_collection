package boj;


import java.util.Scanner;

public class Q13305 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] distance = new int[N];
        int[] price = new int[N];

        for(int i = 0; i < N - 1; i++)
            distance[i] = sc.nextInt();
        for(int i = 0; i < N; i++)
            price[i] = sc.nextInt();

        int cur = 0, next = 0;
        long ret = 0, d = 0;

        while(cur < N) {
            while(next < N && price[cur] <= price[next]) {
                d += distance[next];
                next++;
            }
            if(cur == next) {
                ret += price[cur] * distance[cur];
                cur++;
                next++;
            } else {
                ret += price[cur] * d;
                d = 0;
                cur = next;
            }
        }

        System.out.println(ret);
    }
}