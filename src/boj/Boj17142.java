package boj;

import java.io.*;
import java.util.*;

public class Boj17142 {
    public static int max_val = Integer.MAX_VALUE;
    public static int n, m, a[][], check[][], empty_cnt, cur_cnt, max_time, result = max_val, dx[] = {0, 0, 1, -1}, dy[] = {-1, 1, 0, 0};
    public static ArrayList<Info> v = new ArrayList<>();
    public static Stack<Info> pick = new Stack<>();
    public static Queue<Info> q = new LinkedList<>();

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        a = new int[n+1][n+1];
        check = new int[n+1][n+1];

        for(int i=1; i<=n; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j=1; j<=n; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());

                if(a[i][j] == 0) empty_cnt++;
                else if(a[i][j] == 2) {
                    v.add(new Info(i, j));
                }
            }
        }

        go(0);

        if(result == max_val) result = -1;

        System.out.println(result);
    }

    public static void go(int idx) {
        if(idx >= v.size()) {

            if(pick.size() == m) {
                init();

                for(Info cur: pick) {
                    check[cur.x][cur.y] = 0;
                    q.add(cur);
                }

                bfs();

                if(cur_cnt == 0) {
                    result = min(result, max_time);
                }
            }

            return;
        }


        pick.add(v.get(idx));
        go(idx + 1);
        pick.pop();

        go(idx + 1);
    }

    public static void bfs() {

        while(!q.isEmpty()) {
            Info cur = q.poll();

            int x = cur.x;
            int y = cur.y;

            for(int i=0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 1 || nx > n || ny < 1 || ny > n) continue;

                if(a[nx][ny] != 1 && check[nx][ny] == -1) {
                    check[nx][ny] = check[x][y] + 1;

                    if(a[nx][ny] == 0) {
                        cur_cnt--;

                        max_time = max(max_time, check[nx][ny]);
                    }

                    q.add(new Info(nx, ny));
                }
            }
        }
    }

    public static int max(int a, int b) {
        return a > b ? a : b;
    }

    public static int min(int a, int b) {
        return a < b ? a : b;
    }

    public static void init () {
        cur_cnt = empty_cnt;
        max_time = 0;
        for(int i=0; i<=n; i++) {
            for(int j=0; j<=n; j++) {
                check[i][j] = -1;
            }
        }
    }

    public static class Info {
        int x, y;

        public Info(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
