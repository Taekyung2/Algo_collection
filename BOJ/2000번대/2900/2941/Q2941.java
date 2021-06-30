package boj;

import java.util.Scanner;

public class Q2941 {
    static String[] change = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        for(String s : change)
            str = str.replace(s, "1");
        System.out.println(str.length());
    }
}
