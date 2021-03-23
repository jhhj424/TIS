package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
https://www.acmicpc.net/problem/14907
 */
public class Boj14907 {
    static int[] inDegree = new int[26];
    static int[] times = new int[26];
    static int[] result = new int[26];
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 26; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < 26; i++) {
            String line = br.readLine();
//            if (line == null) break; // 백준 제출용
            if (line.length() == 0) break; // IDE 용
            StringTokenizer st = new StringTokenizer(line);
            int now = st.nextToken().charAt(0)-'A';
            int time = Integer.parseInt(st.nextToken());
            times[now] = result[now] = time;
            if (!st.hasMoreTokens()) continue;
            String[] split = st.nextToken().split("");
            for (int j = 0; j < split.length; j++) {
                inDegree[now]++;
                graph.get(split[j].charAt(0)-'A').add(now);
            }
        }

        tplSort();

        int max = 0;
        for (int i : result) {
            max = Math.max(i, max);
        }
        System.out.println(max);
    }

    private static void tplSort() {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < 26; i++) {
            if (inDegree[i] == 0) {
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            int now = q.poll();
            for (int next : graph.get(now)) {
                result[next] = Math.max(result[next], result[now] + times[next]);
                inDegree[next]--;
                if (inDegree[next] == 0) q.offer(next);
            }
        }
    }
}
