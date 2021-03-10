package boj;

import java.util.Scanner;

/*
https://www.acmicpc.net/problem/2458

양 방향으로 플로이드 와샬 알고리즘 수행!!
    - 모든 노드로의 접근이 가능하면, 내가 몇 번째로 키가 큰지 알 수 있음
 */
public class Boj2458 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n+1][n+1];
        int[][] reverse = new int[n+1][n+1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                arr[i][j] = (int)1e9;
                reverse[i][j] = (int)1e9;
                if (i == j) {
                    arr[i][j] = 0;
                    reverse[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            arr[a][b] = 1;
            reverse[b][a] = 1;
        }

        for (int k = 1; k <= n; k++) {
            for (int a = 1; a <= n; a++) {
                for (int b = 1; b <= n; b++) {
                    arr[a][b] = Math.min(arr[a][b], arr[a][k] + arr[k][b]);
                    reverse[a][b] = Math.min(reverse[a][b], reverse[a][k] + reverse[k][b]);
                }
            }
        }

        // 두 배열에서 값 비교해서 정답 출력
        int total = 0;
        for (int i = 1; i <= n; i++) {
            int cnt = 0;
            for (int j = 1; j <= n; j++) {
                if (arr[i][j] != (int)1e9 || reverse[i][j] != (int)1e9) cnt++;
            }
            if (cnt == n) total++;
        }

        System.out.println(total);
    }
}
