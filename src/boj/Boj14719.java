package boj;

import java.io.*;
import java.util.*;

public class Boj14719 {
    static int[] map;
    static int result, left, right;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        map = new int[w];
        result = left = right = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < w; i++) {
            int n = Integer.parseInt(st.nextToken());
            map[i] = n;
        }

        for (int i = 1; i < w - 1; i++) {
            left = right = 0;
            checkLeft(i);
            checkRight(w, i);

            calculateResult(i);
        }

        System.out.println(result);
    }

    private static void checkLeft(int i) {
        for (int j = 0; j < i; j++) {
            left = Math.max(map[j], left);
        }
    }

    private static void checkRight(int w, int i) {
        for (int j = i + 1; j < w; j++) {
            right = Math.max(map[j], right);
        }
    }

    private static void calculateResult(int i) {
        if (map[i] < left && map[i] < right) {
            result += Math.min(left, right) - map[i];
        }
    }
}