package boj;

import java.util.Arrays;
import java.util.Scanner;

public class Q10814 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Man[] arr = new Man[N];

        for(int i = 0; i < N; i++)
            arr[i] = new Man(sc.nextInt(), sc.next());
        Arrays.sort(arr, (m1, m2) -> m1.age - m2.age);

        for(Man man : arr) {
            System.out.println(man.age + " " + man.name);
        }
    }

    static class Man {
        int age;
        String name;

        Man(int age, String name) {
            this.age = age;
            this.name = name;
        }
    }
}
