package algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
그래프 알고리즘 : 위상 정렬
 */
public class TopologySort {
    // 노드의 개수(V), 간선의 개수(e)
    public static int v, e;
    // 모든 노드에 대한 진입차수는 0으로 초기화
    public static int[] inDegree;
    // 각 노드에 연결된 간선 정보를 담기 위한 연결 리스트 초기화
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        v = sc.nextInt();
        inDegree = new int[v+1];

        // 그래프 초기화
        for (int i = 0; i <= v; i++) {
            graph.add(new ArrayList<>());
        }

        // 방향 그래프의 모든 간선 정보를 입력받기 (a -> b)
        for (int i = 0; i < e; i++) {
            int a = sc.nextInt(); // 선행
            int b = sc.nextInt(); // 후행
            graph.get(a).add(b); // a -> b
            inDegree[b]++; // 후행 노드의 진입 차수 + 1
        }

        topologySort();
    }

    // 위상 정렬 함수
    public static void topologySort() {
        Queue<Integer> q = new LinkedList<>(); // 큐 라이브러리 사용

        // 처음 시작할 때는 진입차수가 0인 노드를 큐에 삽입
        for (int i = 1; i <= v; i++) {
            if (inDegree[i] == 0) {
                q.offer(i);
            }
        }

        // 큐가 빌 때까지 반복
        while (!q.isEmpty()) {
            // 큐에서 원소 꺼내기
            int now = q.poll();

            // 순서를 출력하려면, now 를 출력
            System.out.println(now);

            // 해당 원소와 연결된 노드들의 진입차수에서 1 빼기
            for (int next : graph.get(now)) {
                inDegree[next]--;
                // 새롭게 진입차수가 0이 되는 노드를 큐에 삽입
                if (inDegree[next] == 0) {
                    q.offer(next);
                }
            }
        }
    }
}
