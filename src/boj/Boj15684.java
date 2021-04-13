package boj;

import java.io.*;

/*
https://www.acmicpc.net/problem/15684
 */
public class Boj15684 {
    static int[][] arr;
    static int n,m,h;
    static boolean flag = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        n = Integer.parseInt(split[0]);
        m = Integer.parseInt(split[1]); // 가로선의 개수
        h = Integer.parseInt(split[2]);
        arr = new int[h+1][n+1];
        for (int i = 0; i < m; i++) {
            split = br.readLine().split(" ");
            int a = Integer.parseInt(split[0]);
            int b = Integer.parseInt(split[1]);
            arr[a][b] = 1; // 오른쪽 이동
            arr[a][b+1] = 2; // 왼쪽 이
        }

        for (int i = 0; i <= 3; i++) {
            dfs(1, 0, i);
            if (flag) {
                System.out.println(i);
                return;
            }
        }

        System.out.println(-1);
    }

    private static void dfs(int y, int count, int targetCount) {
        if (flag) return;
        if (count == targetCount) {
            if (check()) flag = true;
            return;
        }

        for (int i = y; i < h+1; i++) {
            for (int j = 1; j < n; j++) {
                if (arr[i][j] == 0 && arr[i][j+1] == 0) {
                    arr[i][j] = 1;
                    arr[i][j+1] = 2;
                    dfs(i, count+1, targetCount);
                    arr[i][j] = arr[i][j+1] = 0;
                }
            }
        }
    }

    private static boolean check() {
        for (int i = 1; i < n+1; i++) {
            int x = 1, y = i;
            for (int j = 1; j < h+1; j++) {
                if (arr[x][y] == 1) y++;
                else if (arr[x][y] == 2) y--;
                x++;
            }
            if (y != i) return false;
        }
        return true;
    }

    private static void printMap(int n, int h, int[][] arr) {
        for (int i = 1; i < h +1; i++) {
            for (int j = 1; j < n +1; j++) {
                System.out.print(arr[i][j]+ " ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println(check());
        System.out.println("----------");
    }
}
