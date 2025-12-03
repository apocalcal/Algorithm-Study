/*
 * 1. 문제 분석
 * - 문제: SWEA 2005. 파스칼의 삼각형
 * - 입력: T개의 테스트 케이스, 정수 N
 * - 출력: 파스칼 규칙에 따라 계산된 값을 N줄 출력.
 * - 핵심:
 *   (1) 파스칼의 삼각형 기본 규칙
 *       - 각 행의 양 끝 값은 1 (pascal[i][0] = 1, pascal[i][i] = 1)
 *       - 내부 값: pascal[i][j] = pascal[i-1][j-1] + pascal[i-1][j]
 *   (2) N행까지 순서대로 구성하며, i행은 i+1개의 숫자를 가진다.
 *
 * 2. 접근 방법
 * - 크기 N x N의 배열을 생성하고, 필요한 위치만 채운다.
 * - 행 i 반복:
 *      pascal[i][0] = 1
 *      pascal[i][i] = 1 (단, i > 0일 때)
 *      내부 j (1 ~ i-1)에 대해 위 항 두 개의 합으로 계산
 * - 매 행 계산 후 해당 행의 0~i 인덱스를 출력
 *
 * 3. 핵심 로직
 * - 삼각형이므로 실제로는 정사각 배열을 쓰지만 각 행에서 필요한 값만 출력.
 * - pascal[i][j] = pascal[i-1][j-1] + pascal[i-1][j] 공식의 정확한 적용.
 */

package SWEA.D2.p2005;

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
			int[][] pascal = new int[N][N];
			StringBuilder sb = new StringBuilder();
			// (중요) 헤더 먼저 출력
			sb.append("#" + test_case).append("\n");
			// 바깥 루프 (줄 담당)
			for (int i = 0; i <= N - 1; i++) {
				// 규칙 1. [i][0]은 무조건 1
				pascal[i][0] = 1;
				// 규칙 2. 가운데 값들 예시 [2][1] = [1][0] + [1][1]
				for (int j = 1; j <= i - 1; j++) { // j=0은 바로 위에서 처리
					pascal[i][j] = pascal[i - 1][j - 1] + pascal[i - 1][j];
				}
				// 규칙 3. [1][1] 부터는 [i][i] = 1 적용됨
				if (i > 0) {
					pascal[i][i] = 1;
				}

				// 결과 출력
				for (int k = 0; k <= i; k++) {
					sb.append(pascal[i][k]).append(" ");
				}
				sb.append("\n");
			}
			System.out.println(sb.toString().trim());
		}
		sc.close();
	}
}

