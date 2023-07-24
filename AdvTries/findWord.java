package AdvTries;

import java.util.HashMap;

class Node {
    char data;
    int count;
    HashMap<Character, Node> hm;

    Node(char d) {
        this.data = d;
        this.count = 0;
        this.hm = new HashMap<>();
    }
}

class Trie {
    Node root;

    public Trie() {
        root = new Node('0');
    }

    public void insert(String word) {
        Node temp = root;
        for (char s : word.toCharArray()) {
            if (!temp.hm.containsKey(s)) {
                Node n = new Node(s);
                temp.hm.put(s, n);
            }
            temp = temp.hm.get(s);
            temp.count++;
        }
    }

    public String unique(String word) {
        Node temp = root;
        StringBuilder s = new StringBuilder();

        for (char ch : word.toCharArray()) {
            s.append(ch);
            temp = temp.hm.get(ch);
            if (temp.count == 1) {
                return s.toString();
            }
        }
        return s.toString();
    }
}
public class findWord {

    public static String[] shortestUniquePrefix(String[] s, int n) {
        Trie trie = new Trie();
        String[] result = new String[n];

        for (int i = 0; i < n; i++) {
            trie.insert(s[i]);
        }

        for (int i = 0; i < n; i++) {
            result[i] = trie.unique(s[i]);
        }

        return result;
    }
    public static void main(String[] args) {
        String[] testWords = {"abcd", "acdb", "many", "mango", "mad"};
        int n = testWords.length;

        String[] uniquePrefixes = shortestUniquePrefix(testWords, n);

        for (String prefix : uniquePrefixes) {
            System.out.println(prefix);
        }
    }
}
