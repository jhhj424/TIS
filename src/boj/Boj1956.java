package boj;

import java.util.Scanner;

/*
https://www.acmicpc.net/problem/1956
 */
public class Boj1956 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt();
        int[][] g = new int[v+1][v+1];

        for (int i = 0; i <= v; i++) {
            for (int j = 0; j <= v; j++) {
                g[i][j] = (int)1e9;
                if (i == j) g[i][j] = 0;
            }
        }

        for (int i = 0; i < e; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            g[a][b] = c;
        }

        for (int k = 1; k <= v; k++) {
            for (int a = 1; a <= v; a++) {
                for (int b = 1; b <= v; b++) {
                    g[a][b] = Math.min(g[a][b], g[a][k] + g[k][b]);
                }
            }
        }

        // 왕복 길이중 최소 값을 마킹
        int min = (int)1e9;
        for (int i = 1; i <= v; i++) {
            for (int j = 1; j <= v; j++) {
                if (i == j) continue;
                min = Math.min(min, g[i][j] + g[j][i]);
            }
        }

        // min 값이 갱신되지 않으면, 싸이클이 존재하지 않음 -> -1 출력
        System.out.println(min == (int)1e9? -1 : min);
    }
}
