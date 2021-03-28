package boj;

import java.util.Scanner;

/*
https://www.acmicpc.net/problem/4963
 */
public class Boj4963 {
    public static int[][] map;
    public static boolean[][] visited;
    public static int cnt = 0;
    public static int w = 0;
    public static int h = 0;
    public static int[] dx = {-1,-1,-1,0,0,1,1,1};
    public static int[] dy = {-1,0,1,-1,1,-1,0,1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            w = sc.nextInt();
            h = sc.nextInt();
            if (w == 0 && h == 0) break;
            map = new int[h][w];
            visited = new boolean[h][w];
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    map[i][j] = sc.nextInt();
                    if (map[i][j] == 0) visited[i][j] = true;
                }
            }

            cnt = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (!visited[i][j]) {
                        cnt++;
                        dfs(i, j);
                    }
                }
            }
            System.out.println(cnt);
            cnt = 0;
        }
    }

    private static void dfs(int i, int j) {
        if (i == h || j == w || i < 0 || j < 0) return;
        if (visited[i][j]) return;
        visited[i][j] = true;
        for (int value : dx) {
            for (int item : dy) {
                dfs(i + value, j + item);
            }
        }
    }
}