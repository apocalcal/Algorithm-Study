/*
 * 1. 문제 분석
 * - 문제: BOJ 10986. 나머지 합
 * - 핵심 원리:
 *   (1) 구간합 % M == 0  ⇔  (S[j] % M) == (S[i-1] % M)
 *   (2) 즉, 같은 나머지를 가진 누적합 S[i]가 몇 번 등장하는지만 세면 된다.
 *
 * - 입력: N (수의 개수), M (나누는 수), N개의 정수
 * - 출력: 부분합이 M으로 나누어떨어지는 (i ≤ j) 구간의 개수
 *
 * 2. 접근 방법
 * - S[i] = 앞에서부터의 누적합
 * - 각 S[i]에 대해 r = S[i] % M 값을 센다.
 * - 경우의 수 구성:
 *    ① S[i] % M == 0 이면, (0 ~ i) 구간은 그대로 나머지가 0 → answer++
 *    ② 같은 나머지가 x번 등장하면, 이 중 2개를 선택하는 조합 수 xC2가 조건을 만족.
 *       즉, x * (x - 1) / 2 를 answer에 더한다.
 *
 * - 왜냐하면:
 *     (S[j] % M) == (S[i-1] % M)  → 두 지점의 나머지가 같으면
 *     S[j] - S[i-1]은 M으로 나누어떨어지기 때문.
 *
 * 3. 핵심 로직
 * - 누적합 S[]를 만들며 나머지 r = S[i] % M를 배열 C[r]에 카운트.
 * - r == 0이면 answer++.
 * - 모든 나머지 버킷 C[k]에 대해 C[k]C2 = C[k] * (C[k] - 1) / 2 더하기.
 */

package BOJ.chap03.p10986;

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        long[] S = new long[N];
        long[] C = new long[M];
        long answer = 0;
        // 합 배열 저장
        S[0] = sc.nextInt();  // 첫 값은 미리 입력받기
        for (int i = 1; i < N; i++) {
            S[i] = S[i - 1] + sc.nextInt();
        }
        for (int i = 0; i < N; i++) {
            int result = (int) (S[i] % M);
            if (result == 0) {
                answer++;
            }
            C[result]++;
        }
        for (int i = 0; i < M; i++) {
            if (C[i] > 1) {
                answer = answer + (C[i] * (C[i] - 1) / 2);
            }
        }
        System.out.println(answer);
    }
}