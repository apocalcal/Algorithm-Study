/*
 * 1. 문제 분석
 * - 문제: SWEA 1860. 진기의 최고급 붕어빵 (D3)
 * - 입력: T개의 테스트 케이스, 각 테스트마다:
 *        N = 손님 수
 *        M = 붕어빵 1개를 만드는 데 걸리는 시간
 *        K = M초마다 만들어지는 붕어빵 개수
 *        이후 N명의 손님 도착 시간 배열
 * - 출력:
 *   모든 손님이 도착했을 때 붕어빵을 정확히 제공할 수 있으면 "Possible",
 *   그렇지 않으면 "Impossible".
 * - 핵심 규칙:
 *   (1) 0초에는 붕어빵을 가지고 있지 않다.
 *   (2) M초마다 K개씩 붕어빵이 추가된다.
 *   (3) 손님은 정해진 도착 시간에 정확히 1개씩 필요하다.
 *   (4) 도착한 순서와 도착 시간 기준으로 필요한 개수보다 적게 만들어졌다면 즉시 실패.
 *
 * 2. 접근 방법
 * - 손님 도착 시간을 오름차순 정렬.
 * - i번째 손님(arrivals[i])이 도착했을 때까지 생산된 붕어빵 수는:
 *       totalBread = (도착 시간 / M) * K
 * - 지금까지 도착한 손님 수는 (i + 1)이므로,
 *     totalBread < (i + 1) 이면 붕어빵이 부족 → "Impossible".
 * - 모든 손님을 처리하면 "Possible".
 *
 * 3. 핵심 로직
 * - 정렬된 arrival 배열 기준 반복.
 * - 생산된 붕어빵 = (arrivals[i] / M) * K
 * - 필요한 붕어빵 = i + 1
 * - 비교 후 부족하면 즉시 break.
 */

package SWEA.D3.p1860;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt(); // 손님 수
			int M = sc.nextInt(); // 붕어빵 하나 당 걸리는 시간
			int K = sc.nextInt(); // 붕어빵 개수
			// 도착 시간 배열 생성
			int[] arrivals = new int[N];
			// 배열 입력받기
			for (int i = 0; i <= N-1; i++) {
				arrivals[i] = sc.nextInt();
			}
			// 1. 시간 흐름대로 정렬
			Arrays.sort(arrivals);
			String result = "Possible" ; // 일단 가능하다고 가정
			// 2. 붕어빵 만드는 데 걸리는 총 시간 계산
			for (int i = 0; i <= N-1; i++) {
				int arrivals_time = arrivals[i];
				// 총 시간 = (도착 시간 / 만드는 시간 ) * 개수
				int bread_time = (arrivals_time / M) * K;
				// 필요한 붕어빵 수 (i+1)
				// 만든 빵이 필요한 개수보다 적을 때
				if(bread_time < i+1) {
					result = "Impossible";
					break; // 더 검사할 필요 없음
				}
			}
			System.out.println("#" + test_case + " " + result);
		}
		sc.close();
	}
}	