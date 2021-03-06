package boj_algorithm._8900;

import java.util.Scanner;

public class Q8958 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i = 0; i < n; i++) {
			char[] arr = sc.next().toCharArray();
			int cnt = 1, sum = 0;
			for(int j = 0; j < arr.length; j++) {
				if(arr[j] == 'O') {
					sum += cnt;
					cnt++;
				}
				else {
					cnt = 1;
				}
			}
			System.out.println(sum);
		}
		sc.close();
	}
}
