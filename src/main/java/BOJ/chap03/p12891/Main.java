/*
 * 1. 문제 분석
 * - 문제: BOJ 12891. DNA 비밀번호 (슬라이딩 윈도우)
 * - 입력: S (전체 문자열 길이), P (비밀번호로 사용할 부분 문자열의 길이),
            DNA 문자열 A (문자: 'A','C','G','T')
 *   네 문자 각각 필요한 최소 개수 checkArr[4]
 *
 * - 출력: 조건을 만족하는 부분 문자열의 개수(result)
 *
 * - 핵심 규칙:
 *   (1) 길이 P의 윈도우(window)를 이동시키며 각 문자의 개수를 관리.
 *   (2) 문자 개수를 myArr에 저장 → checkArr과 비교.
 *   (3) 어떤 문자 idx에 대해 myArr[idx] == checkArr[idx]일 때만 조건 충족.
 *   (4) 조건 충족 문자 종류가 4개 모두면(checkSecret == 4) 유효한 비밀번호.
 *
 * 2. 접근 방법 (슬라이딩 윈도우)
 * - 첫 윈도우: A[0..P-1] Add() 호출하여 초기 카운트 구성.
 * - checkSecret == 4이면 result++
 *
 * - 이후 i = P..S-1 반복:
 *       j = i - P (윈도우에서 제거될 문자)
 *       Add(A[i])     → 새로 들어오는 문자 처리
 *       Remove(A[j])  → 윈도우에서 빠지는 문자 처리
 *       checkSecret == 4이면 result++
 *
 * - Add(), Remove()는 각 문자에 대해
 *     myArr[idx]++, myArr[idx]-- 를 수행하며
 *     조건 충족 여부가 변하면 checkSecret 증감.
 *
 * 3. 핵심 로직
 * - "조건 만족 여부를 즉시 판단하기 위해 checkSecret 사용" → O(1)에 조건 검사 가능.
 * - 슬라이딩 윈도우로 문자열 전체를 O(S)에 처리.
 * - switch-case로 A,C,G,T를 0,1,2,3 인덱스로 매핑.
 */


package BOJ.chap03.p12891;

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int[] checkArr;
    static int[] myArr;
    static int checkSecret;

    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        int result = 0;
        char[] A;
        checkArr = new int[4];
        myArr = new int[4];
        checkSecret = 0;
        A = bf.readLine().toCharArray();
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < 4; i++) {
            checkArr[i] = Integer.parseInt(st.nextToken());
            if (checkArr[i] == 0) {
                checkSecret++;
            }
        }

        for (int i = 0; i < P; i++) {
            Add(A[i]);
        }
        if (checkSecret == 4) {
            result++;
        }

        for (int i = P; i < S; i++) {
            int j = i - P;
            Add(A[i]);
            Remove(A[j]);
            if (checkSecret == 4) {
                result++;
            }
        }
        System.out.println(result);
        bf.close();
    }

    private static void Add(char c) {
        switch (c) {
            case 'A':
                myArr[0]++;
                if (myArr[0] == checkArr[0]) {
                    checkSecret++;
                }
                break;
            case 'C':
                myArr[1]++;
                if (myArr[1] == checkArr[1]) {
                    checkSecret++;
                }
                break;
            case 'G':
                myArr[2]++;
                if (myArr[2] == checkArr[2]) {
                    checkSecret++;
                }
                break;
            case 'T':
                myArr[3]++;
                if (myArr[3] == checkArr[3]) {
                    checkSecret++;
                }
                break;
        }
    }

    private static void Remove(char c) {
        switch (c) {
            case 'A':
                if (myArr[0] == checkArr[0]) {
                    checkSecret--;
                }
                myArr[0]--;
                break;
            case 'C':
                if (myArr[1] == checkArr[1]) {
                    checkSecret--;
                }
                myArr[1]--;
                break;
            case 'G':
                if (myArr[2] == checkArr[2]) {
                    checkSecret--;
                }
                myArr[2]--;
                break;
            case 'T':
                if (myArr[3] == checkArr[3]) {
                    checkSecret--;
                }
                myArr[3]--;
                break;
        }
    }
}
