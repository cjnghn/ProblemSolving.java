package org.example.boj;

// 2696. 중앙값 구하기
// https://www.acmicpc.net/problem/2696

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P2696 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // Number of test cases

        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < T; t++) {
            int M = Integer.parseInt(br.readLine()); // Number of elements in this test case

            // Two heaps: maxHeap for the left half, minHeap for the right half
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();

            sb.append((M + 1) / 2).append("\n"); // Number of medians to output

            int count = 0; // To track output formatting (10 per line)

            StringTokenizer st = null;

            for (int i = 1; i <= M; i++) {
                if (st == null || !st.hasMoreTokens()) {
                    st = new StringTokenizer(br.readLine()); // Read the next line of input when needed
                }

                int num = Integer.parseInt(st.nextToken());

                if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
                    maxHeap.offer(num);
                } else {
                    minHeap.offer(num);
                }

                // Balance the heaps (maxHeap이 1 더 크게)
                if (maxHeap.size() > minHeap.size() + 1) {
                    minHeap.offer(maxHeap.poll());
                } else if (minHeap.size() > maxHeap.size()) {
                    maxHeap.offer(minHeap.poll());
                }

                // Output median for odd indices
                if (i % 2 == 1) {
                    sb.append(maxHeap.peek()).append(" ");
                    count++;

                    // Print a new line after every 10 numbers
                    if (count == 10) {
                        sb.append("\n");
                        count = 0;
                    }
                }
            }

            sb.append("\n"); // New line after each test case
        }

        System.out.print(sb);
    }
}
