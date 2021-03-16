package boj;

import java.util.Scanner;

/*
https://www.acmicpc.net/problem/10159
 */
public class Boj10159 {
    static int INF = (int)1e9;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n+1][n+1];
        int[][] arr_r = new int[n+1][n+1];
        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < n+1; j++) {
                if (i == j) continue;
                arr[i][j] = INF;
                arr_r[i][j] = INF;
            }
        }
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            arr[a][b] = arr_r[b][a] = 1;
        }

        for (int k = 1; k < n+1; k++) {
            for (int a = 1; a < n+1; a++) {
                for (int b = 1; b < n+1; b++) {
                    arr[a][b] = Math.min(arr[a][b], arr[a][k] + arr[k][b]);
                    arr_r[a][b] = Math.min(arr_r[a][b], arr_r[a][k] + arr_r[k][b]);
                }
            }
        }

        for (int i = 1; i < n+1; i++) {
            int cnt = 0;
            for (int j = 1; j < n+1; j++) {
                arr[i][j] = Math.min(arr[i][j], arr_r[i][j]);
                if (arr[i][j] == INF) cnt++;
            }
            System.out.println(cnt);
        }
    }
}
