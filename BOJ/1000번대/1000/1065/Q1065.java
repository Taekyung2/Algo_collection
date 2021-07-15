package boj;

import java.util.Scanner;

public class Q1065 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ret = 0;
        for(int i = 1; i <= n; i++)
            if(chk(i))
                ret++;

        System.out.println(ret);
    }

    public static boolean chk(int n) {
        if(n < 100)
            return true;
        char[] s = Integer.toString(n).toCharArray();
        int dif = (s[0] - '0') - (s[1] - '0');
        for(int i = 0; i < s.length - 1; i++) {
            if(dif != (s[i] - '0') - (s[i + 1] - '0'))
                return false;
        }
        return true;
    }
}