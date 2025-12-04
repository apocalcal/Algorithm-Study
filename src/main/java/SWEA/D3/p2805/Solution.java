/*
 * 1. 문제 분석
 * - 문제: SWEA 2805. 농작물 수확하기 (D3)
 * - 입력: T개의 테스트 케이스, 각 테스트마다 정수 N (N은 홀수), 이어서 N x N 농장 정보(문자 배열)
 * - 출력: 농작물의 가치 합계 (마름모 모양에 해당하는 부분만 수확)
 *
 * - 핵심 규칙:
 *   (1) 가운데 행(mid = N/2)을 기준으로 대칭되는 마름모 영역의 값만 더함.
 *   (2) i < mid  (상단 영역): 각 행에서 수확 범위가 좌우로 1칸씩 증가 → start--, end++
 *   (3) i > mid  (하단 영역): 각 행에서 수확 범위가 좌우로 1칸씩 감소 → start++, end--
 *   (4) i = mid는 가장 넓은 영역(start = 0, end = N-1).
 *
 * 2. 접근 방법
 * - 문자열로 입력받은 행을 한 글자씩 숫자로 변환해 grid[][]에 저장.
 * - 시작 범위(start, end)는 mid = N/2로 설정 → 처음에는 마름모의 꼭대기.
 * - 행을 위에서부터 순서대로 순회하면서:
 *       for j = start ~ end → sum 누적
 *       i < mid → start--, end++
 *       i > mid → start++, end--
 * - 모든 행이 끝나면 sum 출력.
 *
 * 3. 핵심 로직
 * - 마름모 형태는 수평 범위를 start ~ end로 관리하면 쉽게 구현 가능.
 * - 문자를 숫자로 변환: char - '0'
 * - 중앙을 기준으로 증가 후 감소하는 형태의 패턴 구현이 핵심.
 */

package SWEA.D3.p2805;

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
			int[][] grid = new int[N][N];
			for (int i = 0; i <= N-1; i++) {
				String row = sc.next(); // 한 줄을 통째로 문자열로 받음
				for (int j = 0; j <= N-1; j++) {
					grid[i][j] = row.charAt(j) - '0'; // 문자를 숫자로 변환
				}
			}
			// 변수 선언
			int sum = 0;
			int mid = N / 2;
			int start = mid;
			int end = mid; // 처음은 가운데만 해당되므로 start, end 모두 mid
			// 농작물 범위 구하기
			for (int i = 0; i <= N-1; i++) {
				for (int j = start; j <= end; j++) { // start부터 end까지 누적해야 정확
					sum += grid[i][j];
				}
				// 규칙 적용 - i가 mid를 넘어가기 전까진 end가 늘어나고, 넘어가면 start가 늘어남
				if (i < mid) {
					start--;
					end++;
				} else {
					start++;
					end--;
				}
			}
			System.out.println("#" + test_case + " " + sum);
		}
		sc.close();
	}
}		