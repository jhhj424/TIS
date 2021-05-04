package boj;

import java.io.*;
import java.util.*;

public class Boj17779 {

    public static int N;
    public static int[][] map;
    public static int[][] num;
    public static int answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 사각형을 그릴 수 있는지 확인
        answer = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int w = 1; w < N; w++) {
                    for (int h = 1; h < N; h++) {
                        if (j - h < 0 || i + w + h >= N || j + w >= N)
                            continue;
                        count(i, j, w, h);
                    }
                }
            }
        }
        System.out.println(answer);
    }

    public static void count(int r, int c, int w, int h) {
        num = new int[N][N];
        int[] people = new int[5]; // 각 선거구별 인구수를 저장할 배열

        // 5 구역
        int row = r, col = c;
        int width = w, height = h;
        while (width >= 0 && height >= 0) {
            for (int i = 0; i <= width; i++) { // 오른쪽 아래 대각선(w)
                num[row + i][col + i] = 5;
                num[row + height + i][col - height + i] = 5;
            }

            for (int i = 1; i < height; i++) { // 왼쪽 아래 대각선(h)
                num[row + i][col - i] = 5;
                num[row + width + i][col + width - i] = 5;
            }
            width--;
            height--;
            row++;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (num[i][j] == 5)
                    people[4] += map[i][j];
            }
        }

        // 1 구역
        for (int i = 0; i < r + h; i++) {
            for (int j = 0; j <= c; j++) {
                if (num[i][j] != 5)
                    people[0] += map[i][j];
            }
        }

        // 2 구역
        for (int i = 0; i <= r + w; i++) {
            for (int j = c + 1; j < N; j++) {
                if (num[i][j] != 5)
                    people[1] += map[i][j];
            }
        }

        // 3 구역
        for (int i = r + h; i < N; i++) {
            for (int j = 0; j < c + w - h; j++) {
                if (num[i][j] != 5)
                    people[2] += map[i][j];
            }
        }

        // 4 구역
        for (int i = r + w + 1; i < N; i++) {
            for (int j = c + w - h; j < N; j++) {
                if (num[i][j] != 5)
                    people[3] += map[i][j];
            }
        }

        Arrays.sort(people);
        int result = people[4] - people[0];
        if (answer > result)
            answer = result;
    }
}