package main.java.Leetcode.easy;

/**
 * Given an array of words
 */
public class LongestWordInADict {
    public static void main(String[] args) {
        String[] words = {"a", "ap", "app", "appl", "apple"};
        String res = longestWord(words);
        System.out.println(res);
    }

    static String longestWord(String[] words) {
        if(words == null || words.length == 0) {
            return "";
        }

        TrieNode root = new TrieNode();

        for(String word : words) {
            TrieNode cur = root;
            for(Character c : word.toCharArray()) {
                if(cur.children[c-'a'] == null) {
                    cur.children[c-'a'] = new TrieNode();
                }
                cur = cur.children[c-'a'];
            }
            cur.word = word;
        }

        return dfs(root);
    }

    static String dfs(TrieNode root) {
        String res = root.word;
        for (TrieNode child : root.children) {
            if (child != null && child.word.length() != 0) {
                String childWord = dfs(child);
                if (childWord.length() > res.length() || (childWord.length() == res.length() && childWord.compareTo(res) < 0))
                    res = childWord;
            }
        }
        return res;
    }
}
