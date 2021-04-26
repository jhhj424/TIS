package boj;

import java.io.*;
import java.util.ArrayList;

/*
https://www.acmicpc.net/problem/1967
 */
public class Boj1967 {
    static int n;
    static boolean[] visited;
    static Node max = new Node(0, 0);
    static ArrayList<ArrayList<Node>> tree = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        visited = new boolean[n+1];

        for (int i = 0; i <= n; i++) {
            tree.add(new ArrayList<>());
        }

        for (int i = 0; i < n-1; i++) {
            String[] input = br.readLine().split(" ");
            int parent = Integer.parseInt(input[0]);
            int child = Integer.parseInt(input[1]);
            int weight = Integer.parseInt(input[2]);
            tree.get(parent).add(new Node(child, weight));
            tree.get(child).add(new Node(parent, weight));
        }

        // 가장 먼 노드 찾기
        dfs(1, 0);
        visited = new boolean[n+1];

        // 가장 먼 노드에서 시작해서 가장 먼 노드 찾기 == 제일 긴 경로
        dfs(max.vertex, 0);
        System.out.println(max.weight);
    }

    private static void dfs(int vertex, int weight) {
        visited[vertex] = true;

        if (max.weight < weight) {
            max = new Node(vertex, weight);
        }

        for (Node next : tree.get(vertex)) {
            if (visited[next.vertex]) continue;
            dfs(next.vertex, weight + next.weight);
        }
    }

    static class Node {
        int vertex;
        int weight;

        public Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }
}
