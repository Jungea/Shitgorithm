package LTC;

public class LTC208 {

    static class TrieNode {
        boolean word;
        TrieNode[] children;

        public TrieNode() {
            this.word = false;
            children = new TrieNode[26];  // 알파벳
        }
    }

    static class Trie {

        TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode cur = root;

            for (char c : word.toCharArray()) {
                if (cur.children[c - 'a'] == null) {
                    cur.children[c - 'a'] = new TrieNode();
                }
                cur = cur.children[c - 'a'];
            }

            cur.word = true;
        }

        public boolean search(String word) {
            TrieNode cur = root;

            for (char c : word.toCharArray()) {
                if (cur.children[c - 'a'] == null)
                    return false;

                cur = cur.children[c - 'a'];
            }

            return cur.word;
        }

        public boolean startsWith(String prefix) {
            TrieNode cur = root;

            for (char c : prefix.toCharArray()) {
                if (cur.children[c - 'a'] == null)
                    return false;

                cur = cur.children[c - 'a'];
            }

            return true;
        }
    }
}
