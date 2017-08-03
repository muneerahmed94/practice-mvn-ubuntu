package ds.trie;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Muneer on 09-07-2017.
 */

class TrieNode {
    static int noOfTrieNodes = 0;
    Map<Character, TrieNode> children;
    boolean isEOW;

    public TrieNode() {
        this.children = new HashMap<Character, TrieNode>();
        this.isEOW = false;
        noOfTrieNodes++;
    }
}

public class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String s) {
        TrieNode trieNode = root;
        Map<Character, TrieNode> children = trieNode.children;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            trieNode = children.get(ch);
            if (trieNode == null) {
                trieNode = new TrieNode();
                children.put(ch, trieNode);
            }
            children = trieNode.children;
        }

        trieNode.isEOW = true;
        System.out.println("inserted: " + "'" + s + "'");
    }

    public boolean contains(String s) {
        TrieNode trieNode = root;
        Map<Character, TrieNode> children = trieNode.children;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            trieNode = children.get(ch);
            if (trieNode == null)
                return false;
            children = trieNode.children;
        }

        return trieNode.isEOW;
    }

    public boolean delete(String s) {
        return deleteUtil(this.root, s, 0);
    }

    private boolean deleteUtil(TrieNode root, String s, int sPos) {
        if (sPos < s.length()) {
            TrieNode trieNode = root.children.get(s.charAt(sPos));
            if (trieNode == null) {
                return false;
            }

            if (sPos == s.length() - 1) {
                if (trieNode.children.size() == 0) {
                    root.children.remove(s.charAt(sPos));
                }
                trieNode.isEOW = false;
                return true;
            }

            boolean check = deleteUtil(trieNode, s, sPos + 1);
            if (check) {
                if (trieNode.children.size() == 0 && trieNode.isEOW == false) {
                    root.children.remove(s.charAt(sPos));
                }
                return true;
            }
            return false;
        }
        return true;
    }
}

class TestTrie {
    public static void main(String[] args) {
        Trie trie = new Trie();

        add(trie, "car");
        add(trie, "cab");
        add(trie, "cars");
        add(trie, "card");
        add(trie, "cards");
        add(trie, "bat");

        System.out.println(TrieNode.noOfTrieNodes);

        remove(trie, "bat");
        remove(trie, "cab");
        remove(trie, "car");
        remove(trie, "cars");

        printAllNodes(trie);
    }

    private static void printAllNodes(Trie trie) {
        System.out.println("car" + " " + trie.contains("car"));
        System.out.println("cab" + " " + trie.contains("cab"));
        System.out.println("cars" + " " + trie.contains("cars"));
        System.out.println("card" + " " + trie.contains("card"));
        System.out.println("cards" + " " + trie.contains("cards"));
        System.out.println("bat" + " " + trie.contains("bat"));
    }

    private static void add(Trie trie, String word) {
        System.out.println("Contains '" + word + "': " + trie.contains(word));
        trie.insert(word);
        System.out.println("Contains '" + word + "': " + trie.contains(word) + "\n");
    }

    private static boolean remove(Trie trie, String word) {
        System.out.println("Attempting to delete: " + "'" + word + "'");
        boolean status = trie.delete(word);
        System.out.println("Deletion status: " + status);
        System.out.println("Contains '" + word + "': " + trie.contains(word) + "\n");
        return status;
    }
}