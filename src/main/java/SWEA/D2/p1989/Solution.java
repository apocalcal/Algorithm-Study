/*
 * 1. 문제 분석
 * - 문제: SWEA 1989. 초심자의 회문 검사
 * - 입력: T개의 테스트 케이스, 문자열 s
 * - 출력: s가 회문이면 1, 아니면 0
 *
 * - 핵심:
 *   (1) 문자열의 앞 문자와 뒤 문자를 차례로 비교
 *   (2) 하나라도 다르면 회문이 아님 → 즉시 0 반환
 *   (3) 끝까지 문제가 없으면 1 반환
 *   (4) 비교는 문자열 길이의 절반까지만 수행하면 충분
 *
 * 2. 접근 방법
 * - i는 0부터 N/2 - 1까지 반복
 * - start = s.charAt(i)
 *   end   = s.charAt(N - 1 - i)
 * - 다르면 answer = 0 → break
 * - 끝까지 통과하면 answer = 1
 *
 * 3. 핵심 로직
 * - 회문의 정의: 앞뒤가 대칭
 * - 비교 범위: 문자열의 절반만 확인
 * - 일치 여부 확인 후 즉시 break로 불필요한 연산 절약
 */

package SWEA.D2.p1989;

import java.io.FileInputStream;
import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++) {
			String s = sc.next();
			int answer = 1; // 일단 참이라 가정
			int N = s.length();
			for (int i = 0; i <= N / 2 - 1; i++) {
				char start = s.charAt(i);
				char end = s.charAt(N-1-i);
				// 둘이 다르면 회문이 아님!
				if (start != end) {
					answer = 0;
					break; // 회문이 아닌게 확인되면 더 반복해서 검사할 필요 X
				}
			}
			System.out.println("#" + test_case + " " + answer);
		}
		sc.close();
	}
}

