package boj;

import java.util.Arrays;
import java.util.Scanner;

public class Q1475 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next().replace("9", "6");
        int[] card = new int[9];

        for(int i = 0; i < s.length(); i++)
            card[s.charAt(i) - '0']++;
        card[6] = (card[6] + 1) / 2;
        System.out.println(Arrays.stream(card).max().getAsInt());
    }
}
