package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        String str = "1234asdf1235";
        System.out.println(str.replaceAll("\\d+", ""));
    }
}
