/*
 * 1. 문제 분석
 * - 문제: SWEA 1983. 조교의 성적 매기기
 * - 입력:
 *   T개의 테스트 케이스
 *   학생 수 N, 등급을 알고 싶은 학생 번호 K,
 *   학생별 점수(중간 mid, 기말 fin, 과제 hw)
 * - 출력:
 *   K번 학생의 최종 등급(A+ ~ D0) 중 하나를 출력
 * - 핵심:
 *   (1) 학생별 총점을 일정 비율(mid 35%, fin 45%, hw 20%)로 계산.
 *   (2) 총점 기준으로 석차를 매기되, N명은 10개의 등급으로 동일하게 분배한다.
 *   (3) 전체 점수 중 “K번째 학생보다 높은 점수의 개수”를 세어 석차를 구한다.
 *   (4) rank / (N/10)으로 등급 인덱스를 결정한다.
 *
 * 2. 접근 방법
 * - double[] totalScores에 모든 학생의 총점을 저장한다.
 * - targetScore = totalScores[K-1]로 K번 학생의 점수를 확보한다.
 * - score > targetScore인 학생의 수를 rank로 계산한다.
 * - 한 등급당 학생 수는 N/10이므로, gradeIndex = rank / (N/10).
 * - gradeIndex로 미리 정의된 등급 배열에서 결과를 출력.
 *
 * 3. 핵심 로직
 * - 총점 계산: mid*0.35 + fin*0.45 + hw*0.20
 * - 석차 결정: 더 높은 점수의 개수를 rank로 간주
 * - 등급 매핑: grades[gradeIndex]
 */

package SWEA.D2.p1983;

import java.io.FileInputStream;
import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		// 등급 배열 (총 10개)
		String[] grades = {"A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0"};

		for (int test_case = 1; test_case <= T; test_case++) {

			int N = sc.nextInt();  // 총 학생 수
			int K = sc.nextInt();  // 등급을 알고 싶은 학생 번호

			double[] totalScores = new double[N];

			// 모든 학생의 총점 계산
			for (int i = 0; i < N; i++) {
				int mid = sc.nextInt();
				int fin = sc.nextInt();
				int hw  = sc.nextInt();

				totalScores[i] = mid * 0.35 + fin * 0.45 + hw * 0.20;
			}

			// K번 학생 점수
			double targetScore = totalScores[K - 1];

			// targetScore보다 높은 학생 수를 rank로 계산
			int rank = 0;
			for (double score : totalScores) {
				if (score > targetScore) {
					rank++;
				}
			}

			// 한 등급당 학생 수 = N/10
			int gradeIndex = rank / (N / 10);

			System.out.println("#" + test_case + " " + grades[gradeIndex]);
		}

		sc.close();
	}
}
