/*
 * 문제: SWEA 2046. 스탬프 찍기 (D1)
 * 내용: 주어진 숫자만큼 # 출력
 */

package SWEA.D1.p2046;

import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for(int i = 1; i <= N; i++) {
			System.out.print("#");
		}
	}
}
