package boj;

import java.util.Scanner;

/*
https://www.acmicpc.net/problem/1507
 */
public class Boj1507 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] graph = new int[n+1][n+1];
        boolean[][] d = new boolean[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        for (int k = 1; k <= n; k++) {
            for (int a = 1; a <= n; a++) {
                for (int b = 1; b <=n ; b++) {
                    if (a == b || a == k || b == k) continue;

                    if (graph[a][b] > graph[a][k] + graph[k][b]) {
                        System.out.println(-1);
                        return;
                    }

                    if (graph[a][b] == graph[a][k] + graph[k][b]) {
                        d[a][b] = true;

                    }
                }
            }
        }

        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (!d[i][j]) cnt += graph[i][j];
            }
        }

        System.out.println(cnt/2);
    }
}
