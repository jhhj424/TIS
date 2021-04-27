package boj;

import java.io.*;
import java.util.*;

/*
https://www.acmicpc.net/problem/5052
 */
public class Boj5052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            boolean flag = true;
            Trie trie = new Trie();
            for (int j = 0; j < n; j++) {
                if (!trie.insert(br.readLine())) {
                    flag = false;
                    continue;
                }
            }
            System.out.println(flag?"YES":"NO");
        }
    }

    private static class Trie {
        TrieNode root = new TrieNode();

        boolean insert(String input) {
            TrieNode now = root;
            for (int i = 0; i < input.length(); i++) {
                char nowWord = input.charAt(i);
                if (now.child.get(nowWord) == null) {
                    now.child.put(nowWord, new TrieNode());
                }
                now = now.child.get(nowWord);
                // 이미 존재하는 번호일 경우 = 해당 조건에 들어온 now 가 접두어
                if (now.isLast) return false;
            }
            // input 을 다 연결 했는데 뒤에 더 있는 경우 = 현재 input 이 접두어
            if (now.child.size() > 0) return false;
            // 단어를 전부 연결했으니 isLast 를 true 로 update
            now.isLast = true;
            return true;
        }
    }

    private static class TrieNode {
        HashMap<Character, TrieNode> child = new HashMap<>();
        boolean isLast;
    }
}
