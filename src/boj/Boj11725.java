package boj;

import java.util.*;
/*
https://www.acmicpc.net/problem/11725
 */
public class Boj11725 {
    static int[] parents;
    static List<Integer>[] list;
    static boolean[] visit;
    static int n;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();

        list = new ArrayList[n + 1];
        parents = new int[n + 1];
        for (int i = 1; i <= n; i++) list[i] = new ArrayList<>();

        visit = new boolean[n + 1];
        for (int i = 0; i < n - 1; i++) {
            int a = scan.nextInt(), b = scan.nextInt();
            list[a].add(b);
            list[b].add(a);
        }

        dfs(1);
        for (int i = 2; i <= n; i++)
            System.out.println(parents[i]);
    }

    private static void dfs(int now) {
        visit[now] = true;

        for (int i : list[now]) {
            if (!visit[i]) {
                parents[i] = now;
                dfs(i);
            }
        }
    }
}
