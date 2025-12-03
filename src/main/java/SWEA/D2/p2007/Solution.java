/*
 * 1. 문제 분석
 * - 문제: SWEA 2007. 패턴 마디의 길이
 * - 입력: T개의 테스트 케이스, 각 테스트마다 문자열 s (길이 30 이하)
 * - 출력: 문자열에서 반복되는 최소 마디(패턴)의 길이를 출력
 * - 핵심:
 *   (1) 마디의 최대 길이는 10으로 제한되어 있음.
 *   (2) s[0:i] == s[i:2i] 가 되는 가장 작은 i가 정답.
 *   (3) i+i가 문자열 길이를 넘는 경우 더 이상 비교 불가능 → 즉시 종료.
 *
 * 2. 접근 방법
 * - i를 1부터 10까지 증가시키며, 다음 두 구간의 문자열을 비교:
 *     p1 = s.substring(0, i)
 *     p2 = s.substring(i, i+i)
 * - p1과 p2가 일치하면 그 i가 최소 마디 길이가 되므로 answer = i 후 break.
 * - 반복문이 끝나면 해당 test_case에 대한 답을 출력.
 *
 * 3. 핵심 로직
 * - substring을 통해 두 구간을 잘라 비교.
 * - i+i > s.length()이면 더 이상 유효한 비교 불가 → 바로 중단.
 * - p1.equals(p2) 조건이 최초로 참이 되는 i가 정답.
 */

package SWEA.D2.p2007;

import java.io.FileInputStream;
import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		StringBuilder sb = new StringBuilder();

		for(int test_case = 1; test_case <= T; test_case++) {
			// 변수 선언
			String s = sc.next();
			int answer = 0;
			// 마디는 최대 10이므로 1~10번만 반복하며 마디 검사
			for(int i = 1; i <= 10; i++) {
				// (중요!) i+i가 문자열 길이를 넘어가면 종료
				if (i + i > s.length()) {
					break;
				}
				// 두개의 패턴 만들기
				String p1 = s.substring(0, i);
				String p2 = s.substring(i, i+i);
				// 두 마디가 일치하는지 검사
				if (p1.equals(p2)) {
					answer = i;
					break;
				} // 일치하지 않는 경우엔 반복 계속
			}
			// 결과 출력 (템플릿화 하기)
			sb.append("#" + test_case + " " + answer).append("\n");
		}
		System.out.println(sb);
		sc.close();
	}
}