package boj;

import java.io.*;
import java.util.*;

/*
https://www.acmicpc.net/problem/12100
 */
public class Boj12100 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int n;
    static long result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        long[][] board = new long[n][n];
        int remind = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Long.parseLong(st.nextToken());
                if (board[i][j] != 0) remind++;
            }
        }

        for (int i = 0; i < 4; i++) {
            dfs(board, i, 1, remind);
        }

        System.out.println(result);
    }


    public static int turn(int x, int y, int d, long[][] b, long[][] n_b) {
        Deque<Long> dq = new LinkedList<>();
        int nx = x;
        int ny = y;
        int flag = 0;
        int minus = 0;
        while (nx >= 0 && ny >= 0 && nx < n && ny < n) {
            if (b[nx][ny] != 0 && dq.isEmpty()) {
                dq.add(b[nx][ny]);
            } else if (flag == 0 && !dq.isEmpty() && dq.peekLast() == b[nx][ny]) {
                dq.add(dq.pollLast() * 2);
                flag = 1;
                minus++;
            } else if (b[nx][ny] != 0) {
                dq.add(b[nx][ny]);
                flag = 0;
            }
            nx += dx[d];
            ny += dy[d];
        }

        nx = x;
        ny = y;
        while (!dq.isEmpty()) {
            n_b[nx][ny] = dq.pollFirst();
            nx += dx[d];
            ny += dy[d];
        }

        return minus;
    }

    public static void dfs(long[][] b, int d, int cnt, int remind) {
        if (cnt > 5) {
            long max = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (b[i][j] != 0 && max < b[i][j]) {
                        max = b[i][j];
                    }
                }
            }
            result = Math.max(result, max);
            return;
        }

        long[][] n_b = new long[n][n];
        int minus = 0;
        switch (d) {
            case 0:
                for (int i = 0; i < n; i++) {
                    minus = turn(n - 1, i, d, b, n_b);
                }
                break;
            case 1:
                for (int i = 0; i < n; i++) {
                    minus = turn(i, 0, d, b, n_b);
                }
                break;
            case 2:
                for (int i = 0; i < n; i++) {
                    minus = turn(0, i, d, b, n_b);
                }
                break;
            case 3:
                for (int i = 0; i < n; i++) {
                    minus = turn(i, n - 1, d, b, n_b);
                }
                break;
        }

        remind -= minus;

        if (remind == 1) {
            long max = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (b[i][j] != 0 && max < b[i][j]) {
                        max = b[i][j];
                    }
                }
            }
            result = Math.max(result, max);
            return;
        }

        for (int i = 0; i < 4; i++) {
            dfs(n_b, i, cnt + 1, remind);
        }
    }
}