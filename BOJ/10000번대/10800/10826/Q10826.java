package boj;

import java.math.BigInteger;
import java.util.Scanner;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Q10826 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        if(N == 0) {
            System.out.println(0);
            return;
        }

        BigIntSupplier fib = new BigIntSupplier() {
            BigInteger prev = BigInteger.ZERO, cur = BigInteger.ONE;
            @Override
            public BigInteger get() {
                BigInteger next = prev.add(cur);
                prev = cur;
                cur = next;
                return prev;
            }
        };

        Stream.generate(fib)
                .limit(N)
                .skip(N - 1)
                .forEach(System.out::println);
    }

    @FunctionalInterface
    public interface BigIntSupplier extends Supplier<BigInteger> {
        BigInteger get();
    }
}
