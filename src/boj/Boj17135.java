package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj17135 {
    static int n, m, d;
    static int[][] map;
    static int[][][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        d = Integer.parseInt(input[2]);
        map = new int[n+1][m];
        visited = new int[m][m][m];
        for (int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }
        for (int j = 0; j < 3; j++) {
            map[n][j] = 2;
        }

        for (int i = 1; i < n+1; i++) {

        }
//        combination();
        print();


    }

    // 백트래킹 사용
    // 사용 예시 : combination(arr, visited, 0, n, r)
    static void combination(int[] arr, boolean[] visited, int start, int n, int r) {
        if (r == 0) {
            print(arr, visited, n);
            return;
        }

        for (int i = start; i < n; i++) {
            visited[i] = true;
            combination(arr, visited, i + 1, n, r - 1);
            visited[i] = false;
        }
    }

    private static void print(int[] arr, boolean[] visited, int n) {
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                System.out.print(arr[i]+" ");
            }
            System.out.println();
        }
    }

    private static void print() {
        for (int[] i : map) {
            for (int j : i) {
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }
}
