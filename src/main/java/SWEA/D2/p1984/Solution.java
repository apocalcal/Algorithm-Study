/*
 * 1. 문제 분석
 * - 문제: SWEA 1984. 중간 평균값 구하기
 * - 입력: T개의 테스트 케이스, 테스트마다 10개의 정수
 * - 출력: 10개의 정수 중 최솟값과 최댓값을 제외한 나머지 8개의 평균을 반올림하여 정수로 출력.
 * - 핵심:
 *   (1) 최소값과 최대값을 제외한 값들의 평균을 구해야 한다.
 *   (2) 평균 계산 시 반드시 double으로 나누어 소수 계산을 정확히 해야 한다.
 *   (3) Math.round()를 사용해 반올림 처리.
 *
 * 2. 접근 방법
 * - 입력받은 10개의 수를 배열에 저장.
 * - Arrays.sort()로 정렬하여 nums[0] = 최소, nums[9] = 최대를 확보.
 * - nums[1]부터 nums[8]까지의 합을 구한다.
 * - avg = sum / 8.0 형태로 평균 계산.
 * - Math.round(avg)로 반올림 후 정답 출력.
 *
 * 3. 핵심 로직
 * - 정렬 후 최솟값/최댓값을 제외하는 방식으로 문제 단순화.
 * - double 강제 형변환을 통해 정확한 평균 계산.
 * - long answer = Math.round(avg) 사용.
 */

package SWEA.D2.p1984;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++) {
			int N = 10;
			int[] nums = new int[N];
			int sum = 0;
			for(int i = 0; i <= N - 1; i++) {
				nums[i] = sc.nextInt();
			}
			Arrays.sort(nums); // 오름차순 정렬
			// nums[0]이 최소, nums[N-1]이 최대이므로 제외하고, 1부터 N-2까지 합 구하기
			for(int j = 1; j <= N - 2; j++) {
				sum += nums[j];
			}
			double avg = sum / (double)(N - 2); // N이 int형이므로 평균 계산에는 double 강제 형변환 필요!
			long answer = Math.round(avg);
			System.out.println("#" + test_case + " " + answer);
		}
		sc.close();
	}
}