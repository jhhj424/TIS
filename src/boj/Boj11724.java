package boj;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
https://www.acmicpc.net/problem/11724
 */
public class Boj11724 {
    public static boolean[] visited;
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public static int count = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        visited = new boolean[n+1];

        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        for (int i = 1; i < n + 1; i++) {
            bfs(i);
        }

        System.out.println(count);
    }

    private static void bfs(int start) {
        if (visited[start]) return;
        count++;
        visited[start] = true;
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);

        while (!q.isEmpty()) {
            Integer poll = q.poll();
            for (int i = 0; i < graph.get(poll).size(); i++) {
                Integer next = graph.get(poll).get(i);
                if (visited[next]) continue;
                q.offer(next);
                visited[next] = true;
            }
        }
    }
}
