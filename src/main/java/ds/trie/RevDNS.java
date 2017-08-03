package ds.trie;

/**
 * Created by Muneer on 11-07-2017.
 */
public class RevDNS {
    public static void main(String[] args) {
        RTrieNode root = new RTrieNode();
        add(root, "74.125.200.106", "google.com");
        System.out.println("done");
    }

    static void add(RTrieNode trieNode, String ip, String url) {
        RTrieNode[] children = trieNode.children;
        for(int i = 0; i < ip.length(); i++) {
            char ch = ip.charAt(i);
            int x = ch == '.' ? 10 : Character.getNumericValue(ch);

            if(children[x] == null) {
                children[x] = new RTrieNode();
            }

            trieNode = children[x];
            children = trieNode.children;
        }

        trieNode.isLeaf = true;
        trieNode.url = url;
    }
}

class RTrieNode {
    boolean isLeaf;
    RTrieNode[] children;
    String url;

    public RTrieNode() {
        isLeaf = false;
        children = new RTrieNode[11];
    }
}
