/*
 * 1. 문제 분석
 * - 문제: BOJ 11659. 구간 합 구하기 4
 * - 입력: N(수의 개수), M(구간 합을 구해야 하는 질의 개수), N개의 수, 이후 M개의 질의 (i, j)
 *
 * - 출력: 각 질의마다 i번부터 j번까지의 합을 출력.
 *
 * - 핵심 개념:
 *   (1) 누적합(prefix sum) S를 이용하여 O(1)에 구간 합 계산.
 *   (2) 정의:
 *        S[k] = A[1] + A[2] + … + A[k]
 *   (3) 구간 합 공식:
 *        sum(i, j) = S[j] - S[i - 1]
 *
 * 2. 접근 방법
 * - 길이 N+1의 배열 S 생성 (S[0] = 0)
 * - 입력받는 값들을 누적합으로 S[i]에 저장한다.
 * - 각 질의마다 S[j] - S[i-1]을 바로 출력.
 *
 * 3. 핵심 로직
 * - S[0] = 0 으로 시작 → 인덱스 보정 필요 없음
 * - 누적합은 long 타입으로 오버플로우 방지
 * - StringBuilder로 출력 최적화
 */


package BOJ.chap03.p11659;

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
     BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
     StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());
        long[] S = new long[N + 1];
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 1; i <= N; i++) {
            S[i] = S[i - 1] + Integer.parseInt(stringTokenizer.nextToken());
        }
        StringBuilder sb = new StringBuilder();
        for (int q = 0; q < M; q++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int i = Integer.parseInt(stringTokenizer.nextToken());
            int j = Integer.parseInt(stringTokenizer.nextToken());
            sb.append(S[j] - S[i - 1]).append("\n");
        }
        System.out.println(sb);
         }
    }