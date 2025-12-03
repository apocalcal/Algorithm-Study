/*
 * 1. 문제 분석
 * - 문제: SWEA 1986. 지그재그 숫자
 * - 입력: T개의 테스트 케이스, 정수 N
 *
 * - 출력:
 *   1부터 N까지 숫자를 지그재그 방식(홀수는 더하고, 짝수는 빼기)으로 계산한 최종 결과.
 *
 * - 핵심:
 *   (1) i가 홀수 → sum += i
 *   (2) i가 짝수 → sum -= i
 *   (3) 1부터 N까지 반복하면서 누적 계산
 *
 * 2. 접근 방법
 * - sum = 0으로 초기화.
 * - i를 1부터 N까지 증가시키며,
 *     if (i % 2 != 0)  → 홀수 → 더하기
 *     else             → 짝수 → 빼기
 * - 해당 sum을 출력.
 *
 * 3. 핵심 로직
 * - 홀짝 판별: i % 2 != 0
 * - 지그재그 누적 방식: +i, -i 반복
 */

package SWEA.D2.p1986;

import java.io.FileInputStream;
import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int sum = 0;
			for (int i = 1; i <= N; i++) {
				if(i % 2 != 0) {
					sum += i;
				} else {
					sum -= i;
				}
			}
			System.out.println("#" + test_case + " " + sum);
		}
		sc.close();
	}
}


