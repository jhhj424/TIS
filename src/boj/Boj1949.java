package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
https://www.acmicpc.net/problem/1949
 */
public class Boj1949 {
    static int n;
    static int[] citizens;
    static int[][] dp;
    static ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        citizens = new int[n+1];
        dp = new int[n+1][2];
        for (int i = 0; i <= n; i++) {
            tree.add(new ArrayList<>());
        }
        String[] input = br.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            citizens[i] = Integer.parseInt(input[i-1]);
        }
        for (int i = 0; i < n - 1; i++) {
            input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            tree.get(a).add(b);
            tree.get(b).add(a);
        }

        dfs(1, -1);

        System.out.println(Math.max(dp[1][0], dp[1][1]));
    }

    private static void dfs(int now, int parent) {
        for (int child : tree.get(now)) {
            if (child == parent) continue;
            dfs(child, now);
            dp[now][1] += dp[child][0];
            dp[now][0] += Math.max(dp[child][0], dp[child][1]);
        }
        dp[now][1] += citizens[now];
    }
}
