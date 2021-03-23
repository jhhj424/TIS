package boj;

import java.io.*;
import java.util.*;

/*
https://www.acmicpc.net/problem/1766
 */
public class Boj1766 {
    static int n, m;
    static int[] inDegree;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        inDegree = new int[n+1];

        for (int i = 0; i < n+1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int pre = Integer.parseInt(st.nextToken());
            int next = Integer.parseInt(st.nextToken());
            inDegree[next]++;
            graph.get(pre).add(next);
        }

        priorityTplSort();
    }

    private static void priorityTplSort() {
        PriorityQueue<Integer> q = new PriorityQueue<>();

        for (int i = 1; i < n+1; i++) {
            if (inDegree[i] == 0) q.offer(i);
        }

        while (!q.isEmpty()) {
            int now = q.poll();
            System.out.println(now);

            for (int next : graph.get(now)) {
                inDegree[next]--;

                if (inDegree[next] == 0) {
                    q.offer(next);
                }
            }
        }
    }
}
