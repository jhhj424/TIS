package boj;

import java.io.*;

/*
https://www.acmicpc.net/problem/16637
 */
public class Boj16637 {
    static int max = Integer.MIN_VALUE;
    static int n;
    static int[] numbers;
    static char[] operators;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        numbers = new int[n/2+1];
        operators = new char[n/2];
        String[] split = br.readLine().split("");
        for (int i = 0; i < n; i++) {
            if (i % 2 == 1) {
                operators[i/2] = split[i].charAt(0);
            } else {
                numbers[i/2] = Integer.parseInt(split[i]);
            }
        }

        dfs(0, numbers[0]);

        System.out.println(max);
    }

    private static void dfs(int now, int sum) {
        if (now >= operators.length) {
            max = Math.max(max, sum);
            return;
        }
        // 괄호 X
        int next = calculator(sum, operators[now], numbers[now + 1]);
        dfs(now + 1, next);
        // 괄호 O
        if (now+1 >= operators.length) return;
        int right = calculator(numbers[now+1], operators[now+1], numbers[now+2]);
        next = calculator(sum, operators[now], right);
        dfs(now + 2, next);
    }

    private static int calculator(int a, char operator, int b) {
        if (operator == '+') return a + b;
        if (operator == '-') return a - b;
        return a * b;
    }
}
