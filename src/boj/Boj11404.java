package boj;

import java.util.*;

/*
https://www.acmicpc.net/problem/11404
 */
public class Boj11404 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] d = new int[n+1][n+1];

        // 모든 값을 무한으로 초기화
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                d[i][j] = (int)1e9;
            }
        }
        // 자기 자신으로 가는 비용 0으로 초기화
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == j) d[i][j] = 0;
            }
        }

        // 각 간선 값에 대한 정보로 초기화 : a -> b 비용 == c
        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            d[a][b] = Math.min(d[a][b], c);
        }

        // 점화식에 따라 플로이드 워셜 알고리즘 수행: D[a][b] = min(D[a][b], D[a][k] + D[k][b]
        for (int k = 1; k <= n; k++) {
            for (int a = 1; a <= n; a++) {
                for (int b = 1; b <= n; b++) {
                    d[a][b] = Math.min(d[a][b], d[a][k] + d[k][b]);
                }
            }
        }

        // 결과 출력
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (d[i][j] == (int)1e9) System.out.print(0 + " ");
                else System.out.print(d[i][j]+ " ");
            }
            System.out.println();
        }
    }
}
