/*
 * 1. 문제 분석
 * - 문제: BOJ 1546. 평균
 * - 입력: N (과목 수), 점수 배열 A[] (각 점수 ≤ 100)
 * - 출력: 아래 공식에 따라 새로 계산된 평균값 - (모든 점수 / 최고 점수 * 100)의 평균
 *
 * - 핵심 규칙:
 *   (1) 새로운 점수 = (기존 점수 / 최고 점수) * 100
 *   (2) 모든 점수에 대해 새로운 점수를 만든 뒤 평균을 계산한다.
 *   (3) 즉, 결과 = (sum(A) / max) * 100 / N 과 동일.
 *
 * 2. 접근 방법
 * - 배열을 입력받으며 sum을 누적하고 최댓값 max를 구한다.
 * - 문제의 새로운 평균 공식은 다음과 같이 단순화 가능:
 *       new_avg = sum * 100.0 / max / N
 * - double 계산을 위해 마지막에 반드시 실수 연산 포함.
 *
 * 3. 핵심 로직
 * - 합(sum)과 최댓값(max) 동시 계산
 * - 결과 출력: sum * 100.0 / max / N
 * - double 사용 주의
 */

package BOJ.chap03.p1546;

import java.util.*;
import java.lang.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }
        long sum = 0;
        long max = 0;
        for (int i = 0; i < N; i++) {
            if(A[i] > max) max = A[i];
            sum += A[i];
        }
        System.out.println(sum * 100.0 / max / N);
    }
}
