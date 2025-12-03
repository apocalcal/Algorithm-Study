/*
 * 1. 문제 분석
 * - 문제: SWEA 1926. 간단한 369게임
 * - 입력: 정수 N (1 ≤ N ≤ 10,000)
 *
 * - 출력: 1부터 N까지의 수를 순서대로 출력하면서 숫자에 3/6/9가 포함된 횟수만큼 '-'를 출력.
 *   (예: 3 → "-", 36 → "--", 12 → "12")
 *
 * - 핵심:
 *   (1) 숫자를 문자열로 변환하여 자릿수를 순회한다.
 *   (2) '3', '6', '9'가 등장할 때마다 clapCount++.
 *   (3) clapCount가 0이면 숫자 출력, 1 이상이면 '-'를 clapCount만큼 출력.
 *
 * 2. 접근 방법
 * - for i = 1 ~ N:
 *     s_num = Integer.toString(i)
 *     각 자리 문자 검사 → 3/6/9이면 clapCount++
 *     clapCount > 0 → '-' * clapCount 출력
 *     else → 숫자 그대로 출력
 *
 * 3. 핵심 로직
 * - 자리수 검사: s_num.charAt(j)
 * - 비교 대상: '3', '6', '9'
 * - 출력 처리: StringBuilder로 성능 향상
 */

package SWEA.D2.p1926;

import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			// 숫자를 문자열로 변환
			String s_num = Integer.toString(i);
			int length = s_num.length();
			int clapCount = 0;
			// 문자로 변환해서 3,6,9마다 count 증가
			for (int j = 0; j <= length - 1; j++) {
				char ch = s_num.charAt(j);
				if (ch == '3' || ch == '6' || ch == '9') {
					clapCount++;
				}
			}
			// 카운트 결과에 따라 append
			if (clapCount > 0) {
				for (int k = 0; k <= clapCount - 1; k++) {
					sb.append("-");
				}
			} else {
				sb.append(s_num); // 카운트 0이면 숫자 그대로 출력
			}
			sb.append(' ');
		}
		System.out.print(sb.toString().trim());
	}
}
