package SWEA.D3.p1289;

import java.io.FileInputStream;
import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++) {
			String target = sc.next();
			char current = '0';
			int count = 0;
			// 문자열 길이만큼 반복
			for (int i = 0; i <= target.length() - 1; i++) {
				// 같으면 패스, 다르면 목표값으로 체인지
				if (target.charAt(i) != current) {
					count++;
					current = target.charAt(i); // 목표값을 그냥 current에 넣으면 됨 자피 0 아니면 1이라서
				}
			}
			System.out.println("#" + test_case + " " + count);
		}
		sc.close();
	}
}	
