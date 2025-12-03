/*
 * 문제: SWEA 2047. 신문 헤드라인 (D1)
 * 내용: 주어진 문장의 모든 소문자 알파벳을 찾아 대문자로 변환 출력하는 문제
 */

package SWEA.D1.p2047;

import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {
//		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		String N = "";
		N = sc.next();
		String result = N.toUpperCase();
		System.out.println(result);
	}
}
