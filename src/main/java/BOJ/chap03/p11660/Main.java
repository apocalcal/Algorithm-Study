/*
 * 1. 문제 분석
 * - 문제: BOJ 11660. 구간 합 구하기 5
 * - 입력: N x N 정수 배열 A, M개의 질의 (x1, y1, x2, y2)
 *
 * - 출력: 각 질의에 대해, A[x1..x2][y1..y2] 구간의 요소 합을 출력.
 *
 * - 핵심 개념 (2차원 누적합):
 *     D[i][j] = (1,1) ~ (i,j) 직사각형 내 모든 값의 합
 *
 *     2차원 합 배열 공식:
 *       D[i][j] = D[i-1][j] + D[i][j-1] - D[i-1][j-1] + A[i][j]
 *
 *     구간 합 공식:
 *       sum(x1,x2,y1,y2) =
 *         D[x2][y2]
 *       - D[x1-1][y2]
 *       - D[x2][y1-1]
 *       + D[x1-1][y1-1]
 *
 * 2. 접근 방법
 * - A를 입력받고, 1-based 인덱스로 처리한다.
 * - 2차원 누적합 배열 D를 생성하여 모든 (i,j)에 대해 D[i][j]를 계산한다.
 * - 각 질의마다 위의 누적합 공식을 그대로 적용해 O(1)로 구간 합 계산.
 *
 * 3. 핵심 로직
 * - D는 크기 (N+1)x(N+1)로 만들어서 인덱스 보정 편하게.
 * - 2D prefix sum 4요소: 위 + 왼쪽 - 대각선 + 현재값
 * - 문자열 출력 최적화를 위해 StringBuilder 사용.
 */

package BOJ.chap03.p11660;

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());
        int[][] A = new int[N + 1][N + 1];
        for(int i = 1; i <= N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 1; j <= N; j++) {
                A[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }
        int[][] D = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                D[i][j] = D[i - 1][j] + D[i][j - 1] - D[i - 1][j - 1] + A[i][j];
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int x1 = Integer.parseInt(stringTokenizer.nextToken());
            int y1 = Integer.parseInt(stringTokenizer.nextToken());
            int x2 = Integer.parseInt(stringTokenizer.nextToken());
            int y2 = Integer.parseInt(stringTokenizer.nextToken());
            sb.append(D[x2][y2] - D[x1 - 1][y2] - D[x2][y1 - 1] + D[x1 - 1][y1 - 1]).append("\n");
        }
        System.out.println(sb);
    }
}