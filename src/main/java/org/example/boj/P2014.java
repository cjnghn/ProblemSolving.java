package org.example.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P2014 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] primes = new int[K];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            primes[i] = Integer.parseInt(st.nextToken());
        }

        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (int prime : primes) {
            pq.add((long) prime);
        }

        long current = 0;
        for (int i = 0; i < N; i++) {
            current = pq.poll();
            for (int prime : primes) {
                long next = current * prime;

                // Integer.MAX_VALUE 검사 제거
                if (next > Integer.MAX_VALUE) {
                    break; // 조기 종료
                }

                pq.add(next);

                // 중복 제거: 다음 값이 현재 값과 같으면 무시
                while (!pq.isEmpty() && pq.peek() == current) {
                    pq.poll();
                }
            }
        }

        System.out.println(current);
    }
}
