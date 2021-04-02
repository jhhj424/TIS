package boj;

import java.util.*;

/*
https://www.acmicpc.net/problem/1966
 */
public class Boj1966 {
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int allTestCaseCnt = sc.nextInt();

        for (int i = 0; i < allTestCaseCnt; i++) {
            // 로직 처리
            int n = sc.nextInt();
            int targetIdx = sc.nextInt();
            Queue<Doc> q = new LinkedList<>();
            Doc target = null;
            for (int j = 0; j < n; j++) {
                int nextInt = sc.nextInt();
                Doc doc = new Doc(nextInt, j);
                q.offer(doc);

                if (targetIdx == j) {
                    target = doc;
                }
            }

            int result = 0;
            while (!q.isEmpty()) {
                Doc now = q.peek();
                if (isBest(now.importance, q)) {
                    result++;
                    if (now.equals(target)) {
                        System.out.println(result);
                        break;
                    }
                } else {
                    q.offer(now);
                }
                q.poll();
            }
        }

    }

    private static boolean isBest(int importance, Queue<Doc> q) {
        return q.stream()
                .mapToInt(value -> value.importance)
                .max()
                .getAsInt() // max
                == importance;
    }

    static class Doc {
        int importance;
        int index;
        Doc(int importance, int index) {
            this.importance = importance;
            this.index = index;
        }
    }
}
