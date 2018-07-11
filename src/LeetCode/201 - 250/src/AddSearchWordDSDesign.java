
public class AddSearchWordDSDesign {
    /** Build a trie has boolean isWord, an array of children 26 TrieNode*/
    TrieNode root;
    public AddSearchWordDSDesign() {
        root = new TrieNode();
    }
    
    class TrieNode {
        boolean isWord;
        TrieNode[] children;
        public TrieNode() {
            this.isWord = false;
            this.children = new TrieNode[26];
        }
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode node = root;
        for(int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if(node.children[index] == null) node.children[index] = new TrieNode();
            node = node.children[index];
        }
        node.isWord = true;
    }
    
    /** dfs. keep an index and the string and the node. when the index reached the length() of word, return true.
    when the char at the index is not a dot, search for the child at that index. 
    else increase the index and dfs with all the children. if any of the children returns true, the results are going to pass up.
    */
    public boolean search(String word) {
        return search(root, 0, word);
    }
    
    private boolean search(TrieNode node, int index, String word) {
        if(node == null) return false;
        if(index == word.length()) return node.isWord;
        int i = word.charAt(index) - 'a';
        if(word.charAt(index) != '.') {
            return search(node.children[i], index + 1, word);
        } else {
            for(TrieNode child : node.children) {
                if(search(child, index + 1, word)) return true;
            }
            return false;
        }
    }
}
