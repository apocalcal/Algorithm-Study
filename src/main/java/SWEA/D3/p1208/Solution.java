/*
 * 1. 문제 분석
 * - 문제: SWEA 1208. Flatten (D3)
 * - 입력: 총 10개의 테스트 케이스, 각 테스트마다 덤프 횟수, 이어서 100개의 상자 높이 배열
 * - 출력: 평탄화 작업이 종료된 후 (최대 높이 - 최소 높이)
 *
 * - 핵심 규칙:
 *   (1) 한 번의 덤프는 가장 높은 상자(--), 가장 낮은 상자(++)를 각각 1씩 조절.
 *   (2) “높이 차 ≤ 1”이면 더 이상의 평탄화는 의미 없으므로 즉시 종료.
 *   (3) 매 덤프마다 배열을 정렬해 최대/최소를 빠르게 얻는다.
 *
 * 2. 접근 방법
 * - 매 반복마다 Arrays.sort(boxes)를 수행하여
 *     boxes[0]  → 최소값
 *     boxes[99] → 최대값
 * - 조건: (boxes[99] - boxes[0] <= 1) 이면 break.
 * - 그렇지 않으면
 *     boxes[0]++   // 최소 상자 높이 증가
 *     boxes[99]--  // 최대 상자 높이 감소
 * - 모든 dump가 끝난 후 한 번 더 정렬하여 정확한 최소/최대 산출.
 *
 * 3. 핵심 로직
 * - 덤프 횟수만큼 반복하되, 중간에 평탄화가 완료되면 즉시 종료하는 조기 탈출.
 * - Arrays.sort()를 사용한 간단한 접근(문제 난이도 대비 충분).
 * - 결과 = 최대값 - 최소값.
 */

package SWEA.D3.p1208;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);

		for(int test_case = 1; test_case <= 10; test_case++) {
			int dump = sc.nextInt(); // 덤프 횟수
			// 배열 입력받기
			int[] boxes = new int[100];
			for (int i = 0; i <= 99; i++) {
				boxes[i] = sc.nextInt();
			}
			// 덤프 평탄화 실행
			for (int k = 1; k <= dump; k++) {
				// 매번 정렬해서 최소, 최대 쉽게 찾기
				Arrays.sort(boxes);
				// 평탄화 완료 시 즉시 종료
				if (boxes[99] - boxes[0] <= 1) {
					break;
				}
				// 평탄화 진행 - 최소 + 1, 최대 - 1
				boxes[0]++;
				boxes[99]--;
			}
			Arrays.sort(boxes); // 마지막 덤프 후 순서가 꼬일 수도 있으니 한번 더 정렬
			// 정답 구하기 - 최대 - 최소
			int answer = boxes[99] - boxes[0];
			System.out.println("#" + test_case + " " + answer);
		}
		sc.close();
	}
}	