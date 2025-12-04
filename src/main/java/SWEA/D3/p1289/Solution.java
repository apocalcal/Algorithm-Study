/*
 * 1. 문제 분석
 * - 문제: SWEA 1289. 원재의 메모리 복구하기 (D3)
 * - 입력: T개의 테스트 케이스, 각 테스트마다 0과 1로 구성된 문자열 target이 주어짐
 *
 * - 출력: 초기 메모리가 모두 '0'이라고 가정할 때,
 *  	  target과 동일한 메모리를 만들기 위해 필요한 최소 변경 횟수.
 *
 * - 핵심 규칙:
 *   (1) current는 처음에 '0'으로 시작한다.
 *   (2) target[i] != current인 위치가 "변경이 필요한 순간".
 *       이때 count++를 하고 current를 target[i]로 갱신.
 *   (3) 변경은 연속된 구간을 한 번에 바꾸는 개념이므로,
 *       '0 → 1' 또는 '1 → 0' 상태 전환을 세는 것이 문제의 본질.
 *
 * 2. 접근 방법
 * - target 문자열을 앞에서부터 끝까지 순차적으로 검사.
 * - current와 target[i]가 다르면:
 *       count++ 수행
 *       current = target[i] 로 상태 갱신
 * - 문자열 전체를 순회한 뒤 count 출력.
 *
 * 3. 핵심 로직
 * - 초기 상태: current = '0'
 * - 전환 지점을 세는 방식: (target[i] != current) → 상태 전환 발생
 * - count는 전환 횟수와 동일
 */

package SWEA.D3.p1289;

import java.io.FileInputStream;
import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++) {
			String target = sc.next();
			char current = '0';
			int count = 0;
			// 문자열 길이만큼 반복
			for (int i = 0; i <= target.length() - 1; i++) {
				// 같으면 패스, 다르면 목표값으로 체인지
				if (target.charAt(i) != current) {
					count++;
					current = target.charAt(i); // 목표값을 그냥 current에 넣으면 됨 자피 0 아니면 1이라서
				}
			}
			System.out.println("#" + test_case + " " + count);
		}
		sc.close();
	}
}	
