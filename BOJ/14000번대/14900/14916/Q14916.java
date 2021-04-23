import java.util.Scanner;

public class Q14916 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int five = N / 5;
        N %= 5;
        int two = N / 2;
        N %= 2;
        while(five != 0) {
            if(N != 0) {
                five--;
                N += 5;
            }
            if (N % 2 == 0) {
                two += N / 2;
                break;
            }
        }
        if(five != 0)
            System.out.println(five + two);
        else
            System.out.println(-1);
    }
}
