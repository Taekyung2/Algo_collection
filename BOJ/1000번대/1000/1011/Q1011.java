import java.util.Scanner;

public class Q1011 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        while(tc-- > 0) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            long dist = 0, i = 1;
            while(dist < y - x)
                dist += (i++ + 1) / 2;

            System.out.println(i - 1);
        }
    }
}