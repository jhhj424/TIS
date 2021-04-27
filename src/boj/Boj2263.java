package boj;

import java.io.*;

/*
https://www.acmicpc.net/problem/2263
 */
public class Boj2263 {
    static int[] inOrder, postOrder, roots;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = toInt(br.readLine());
        inOrder = new int[n+1];
        postOrder = new int[n+1];
        roots = new int[n+1];
        String[] input = br.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            inOrder[i] = toInt(input[i-1]);
        }
        input = br.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            postOrder[i] = toInt(input[i-1]);
        }
        for (int i = 1; i <= n; i++) {
            roots[inOrder[i]] = i;
        }

        preOrder(0, n, 0, n);
    }

    private static void preOrder(int inBegin, int inEnd, int postBegin, int postEnd) {
        if (inBegin > inEnd || postBegin > postEnd || postEnd == 0) return;

        int root = postOrder[postEnd];
        System.out.println(root);

        int left = roots[root] - inBegin;

        // Left
        preOrder(inBegin, roots[root] - 1, postBegin, postBegin + left -1);
        // Right
        preOrder(roots[root] + 1, inEnd, postBegin + left, postEnd - 1);
    }

    private static int toInt(String s) {
        return Integer.parseInt(s);
    }
}
