package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
https://www.acmicpc.net/problem/17281
 */
public class Boj17281 {
    static BufferedReader br;
    static int[][] batters;
    static int n;
    static Baseball game;
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        batters = new int[n][9];
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < 9; j++) {
                batters[i][j] = Integer.parseInt(s[j]);
            }
        }

        perm(new int[]{0,1,2,3,4,5,6,7,8}, new int[9], new boolean[9], 0);


        System.out.println(max);
    }

    // 사전순 순열
    static void perm(int[] arr, int[] output, boolean[] visited, int depth) {
        if (depth == 9 && output[3] == 0) {
            gameStart(output);
            return;
        }

        for (int i = 0; i < 9; i++) {
            if (visited[i] != true) {
                visited[i] = true;
                output[depth] = arr[i];
                perm(arr, output, visited, depth + 1);
                visited[i] = false;
            }
        }
    }

    private static void gameStart(int[] output) {
        game = new Baseball();
        int batter = 0;
        for (int i = 0; i < n; i++) { // 이닝
            game.out = 0;
            game.first = -1;
            game.second = -1;
            game.third = -1;
            while (!game.isEnd()) { // 타자 돌아가기!
                while (game.isInner(output[batter % 9])) { // 타자 뽑기
                    batter++;
                }

                batter = batter % 9;
                int nowBatter = output[batter];
                int result = batters[i][nowBatter];
                if (result == 0)      game.out();
                else if (result == 1) game.first(nowBatter);
                else if (result == 2) game.second(nowBatter);
                else if (result == 3) game.third(nowBatter);
                else if (result == 4) game.homeRun();
                batter += 1;
            }
        }

        max = Math.max(max, game.score);
    }

    static class Baseball {
        static int OUT_COUNT = 3;

        int first;;
        int second;
        int third;
        int score;
        int out;

        public Baseball() {
            this.first = -1;
            this.second = -1;
            this.third = -1;
            this.score = 0;
            this.out = 0;
        }

        public void out() {
            out++;
        }

        public void first(int batter) {
            if (third != -1) score++;
            third = second;
            second = first;
            first = batter;
        }

        public void second(int batter) {
            if (third != -1) score++;
            if (second != -1) score++;
            third = first;
            second = batter;
            first = -1;
        }

        public void third(int batter) {
            if (third != -1) score++;
            if (second != -1) score++;
            if (first != -1) score++;
            first = -1;
            second = -1;
            third = batter;
        }

        public void homeRun() {
            score++;
            if (third != -1) score++;
            if (second != -1) score++;
            if (first != -1) score++;
            first = -1;
            second = -1;
            third = -1;
        }

        public boolean isEnd() {
            return OUT_COUNT == out;
        }

        public boolean isInner(int batter) {
            batter = batter % 9;
            if (batter == first) return true;
            if (batter == second) return true;
            if (batter == third) return true;
            return false;
        }
    }
}
