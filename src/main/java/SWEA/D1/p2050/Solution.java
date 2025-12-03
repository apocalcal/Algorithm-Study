/*
 * 문제: SWEA 2050. 알파벳을 숫자로 변환 (D1)
 * 내용: 알파벳을 숫자로 변환하는 프로그램
 */

package SWEA.D1.p2050;

import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		String N = "";
		N = sc.next();

		char[] c = new char[N.length()];
		int result = 0;
		for (int i = 0; i < c.length; i++) {
			result = c[i] - 'A' + 1;
			System.out.print(result + " ");
		}
	}
	
}
