import java.util.ArrayDeque;
import java.util.Scanner;

public class Q1935 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayDeque<Double> stk = new ArrayDeque<>();
        int N = sc.nextInt();
        char[] ex = sc.next().toCharArray();
        double[] arr = new double[N];
        for(int i = 0; i < N; i++)
            arr[i] = sc.nextInt();

        for(char c : ex) {
            if(Character.isAlphabetic(c))
                stk.push(arr[c - 'A']);
            else {
                double a = stk.pop();
                double b = stk.pop();
                stk.push(calc(b, a, c));
            }
        }
        System.out.printf("%.2f", stk.pop());
    }

    static double calc(double a, double b, char op) {
        if(op == '+') return a + b;
        else if(op == '-') return a - b;
        else if(op == '*') return a * b;
        else return a / b;
    }
}
