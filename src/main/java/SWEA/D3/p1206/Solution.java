/*
 * 1. 문제 분석
 * - 문제: SWEA 1206. View (D3)
 * - 입력: 총 10개의 테스트 케이스, 각 테스트마다 건물 개수 N, 이어서 N개의 건물 높이
 * - 출력: 조망권이 확보된 세대의 총합
 *
 * - 핵심 규칙:
 *   (1) 건물 k의 양 옆으로 2칸씩, 총 4칸에 위치한 건물들의 높이보다
 *       현재 건물의 높이가 더 높을 때만 조망권 확보 가능.
 *   (2) 조망권 수 = (myHeight - 주변 4개 건물 중 최대 높이).
 *   (3) 맨 앞 2칸, 맨 뒤 2칸은 비교할 건물이 충분하지 않으므로 계산 제외.
 *
 * 2. 접근 방법
 * - buildings[k]를 기준으로
 *     leftMax = max(buildings[k-2], buildings[k-1])
 *     rightMax = max(buildings[k+1], buildings[k+2])
 *     maxNeighbor = max(leftMax, rightMax)
 * - if (myHeight > maxNeighbor)
 *       answer += (myHeight - maxNeighbor)
 * - k의 범위는 2 ~ N-3까지 순회.
 *
 * 3. 핵심 로직
 * - Math.max()를 활용하여 이웃 건물들의 최댓값을 구함.
 * - myHeight가 maxNeighbor보다 클 때만 조망권 증가.
 * - 10개의 테스트 케이스가 고정되어 있으므로 반복을 10번 수행.
 */

package SWEA.D3.p1206;

import java.io.FileInputStream;
import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);

		for(int test_case = 1; test_case <= 10; test_case++) {
			int N = sc.nextInt(); // 건물의 개수
			int[] buildings = new int[N];
			for (int i = 0; i <= N - 1; i++) {
				buildings[i] = sc.nextInt();
			}
			int answer = 0;
			// 맨 앞 2칸 및 맨 뒤 2칸은 0이기에 제외하고 반복
			for (int k = 2; k <= N - 3; k++) {
				int myHeight = buildings[k];
				// 주변 4개 건물 대장 구하기
				int leftMax = Math.max(buildings[k - 2], buildings[k - 1]);
				int rightMax = Math.max(buildings[k + 1], buildings[k + 2]);
				int maxNeighbor = Math.max(leftMax, rightMax); // max 함수는 2개씩 비교 가능하므로 이렇게 끊어서 하기
				// 조망권 구하기
				if (myHeight > maxNeighbor) {
					answer = answer + (myHeight - maxNeighbor);
				}
			}
			System.out.println("#" + test_case + " " + answer);
		}
		sc.close();
	}
}	