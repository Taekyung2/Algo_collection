package boj_algorithm._2800;

import java.util.Scanner;

public class Q2884 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int h = sc.nextInt();
		int m = sc.nextInt();
		if(m < 45) {
			if(h == 0)
				System.out.println(23 + " " + (m + 15));
			else
			System.out.println((h - 1) + " " + (m + 15));
		}
		else System.out.println(h + " " + (m - 45));
		sc.close();
	}
}
