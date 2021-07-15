package boj;

public class Q4673 {
    static boolean[] chk = new boolean[10001];

    public static void main(String[] args) {
        for(int i = 1; i <= 10000; i++)
            generate(i);

        for(int i = 1; i <= 10000; i++)
            if(!chk[i])
                System.out.println(i);
    }

    public static void generate(int n) {
        int num = n;
        while(n > 0) {
            num += n % 10;
            n /= 10;
        }
        if(num <= 10000)
            chk[num] = true;
    }
}