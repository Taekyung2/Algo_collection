import java.util.Scanner;

public class Q1009 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        while(tc-- > 0) {
            int a = sc.nextInt();
            int b = (sc.nextInt() - 1) % 4 + 1;
            System.out.println(((int)Math.pow(a, b) - 1) % 10 + 1);
        }

    }
}