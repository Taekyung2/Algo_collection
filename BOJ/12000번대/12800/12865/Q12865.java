package boj;

import java.io.*;
import java.util.*;

public class Q12865 {
    static int N, K;
    static Product[] products;
    static int[][] cache;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        products = new Product[N];
        cache = new int[N + 1][K + 1];

        for(int idx = 0; idx < N; idx++)
            products[idx] = new Product(sc.nextInt(), sc.nextInt());
        System.out.println(getMaxValue(0, K));
    }

    public static int getMaxValue(int n, int k) {
        if(k < 0)
            return Integer.MIN_VALUE;
        if(n == N)
            return 0;
        int ret = cache[n][k];
        if(ret != 0)
            return ret;
        return cache[n][k] = Math.max(getMaxValue(n + 1, k),
                getMaxValue(n + 1, k - products[n].w) + products[n].v);
    }

    static class Product {
        int w, v;

        Product(int w, int v) {
            this.w = w;
            this.v = v;
        }
    }
}

/**
 *  1. 물건의 무게, 물건의 가치, K만큼의 무게를 가지고 최대의 가치를 만드는 문제
 *  2. cache[n][k] = n 인덱스 이상의 물건을 담을 수 있고, k만큼의 무게 여유가 있을 때 최대 가치
 *  3. cache[n][k] = cache[n + 1][k], cache[n + 1][k - weight[n]] 중에 큰 것
 *  4. n번째 물건을 선택 하거나 하지 않거나
 */