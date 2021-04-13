package boj;

import java.io.*;

/*
https://www.acmicpc.net/problem/18808
 */
public class Boj18808 {
    static int n,m,k, cnt = 0;
    static BufferedReader br;
    static int[][] noteBook;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        k = Integer.parseInt(s[2]);
        noteBook = new int[n][m];
        for (int i = 0; i < k; i++) {
            s = br.readLine().split(" ");
            int h = Integer.parseInt(s[0]);
            int w = Integer.parseInt(s[1]);
            int[][] sticker = createSticker(h, w);

            for (int j = 0; j < 4; j++) {
                if (tryAttach(sticker))
                    break;
                // 스티커 시계방향 90도 회전
                sticker = turn(sticker);
            }
        }

        System.out.println(cnt);
    }

    private static int[][] createSticker(int h, int w) throws IOException {
        int[][] sticker = new int[h][w];
        for (int i = 0; i < h; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < w; j++) {
                sticker[i][j] = Integer.parseInt(s[j]);
            }
        }
        return sticker;
    }

    private static boolean tryAttach(int[][] sticker) {
        for (int dy = 0; dy < n; dy++) {
            for (int dx = 0; dx < m; dx++) {
                if (isAttachable(sticker, dy, dx)) {
                    attach(sticker, dy, dx);
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isAttachable(int[][] sticker, int dy, int dx) {
        int h = sticker.length;
        int w = sticker[0].length;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (sticker[i][j] == 0) continue;
                int ny = dy + i;
                int nx = dx + j;
                if (ny >= n || nx >= m) return false;
                if (noteBook[ny][nx] == 1) return false;
            }
        }
        return true;
    }

    private static void attach(int[][] sticker, int dy, int dx) {
        if (dy == Integer.MAX_VALUE) return;
        int h = sticker.length;
        int w = sticker[0].length;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                int ny = dy + i;
                int nx = dx + j;
                if (noteBook[ny][nx] == 1 || sticker[i][j] == 0) continue;
                noteBook[ny][nx] = 1;
                cnt++;
            }
        }
    }

    private static int[][] turn(int[][] sticker) {
        int h = sticker[0].length;
        int w = sticker.length;
        int[][] newSticker = new int[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                newSticker[i][j] = sticker[w-j-1][i];
            }
        }
        return newSticker;
    }
}
