class Trie {

    class Node {
        Node[] child = new Node[26];
        boolean end;
    }

    Node root = new Node();

    public Trie() {
        
    }

    public void insert(String word) {
        Node curr = root;

        for (char c : word.toCharArray()) {
            int i = c - 'a';

            if (curr.child[i] == null) {
                curr.child[i] = new Node();
            }

            curr = curr.child[i];
        }

        curr.end = true;
    }

    public boolean search(String word) {
        Node curr = root;

        for (char c : word.toCharArray()) {
            int i = c - 'a';

            if (curr.child[i] == null) {
                return false;
            }

            curr = curr.child[i];
        }

        return curr.end;
    }

    public boolean startsWith(String prefix) {
        Node curr = root;

        for (char c : prefix.toCharArray()) {
            int i = c - 'a';

            if (curr.child[i] == null) {
                return false;
            }

            curr = curr.child[i];
        }

        return true;
    }
}
/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */