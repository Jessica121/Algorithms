
public class ImplementTrie {
    /** has to have a root right here, with ppties like isword, children of 26. */
    TrieNode root;
    public ImplementTrie() {
        root = new TrieNode();
    }
    
    class TrieNode {
        boolean isWord;
        TrieNode[] children;
        public TrieNode() {
            isWord = false;
            children = new TrieNode[26];
        }
    }
    
    /** for each char, insert into the posison, calculate by char - 'a', and if not null, use, if null, create and use.
    at the end mark the node as isWord.*/
    public void insert(String word) {
        TrieNode node = root;
        for(int i = 0; i < word.length(); i++) {
            int ind = word.charAt(i) - 'a';
            if(node.children[ind] == null) node.children[ind] = new TrieNode();
            node = node.children[ind];
        }
        node.isWord = true;
    }
    
    /** search for the word char by char. if child is null, false. if end not word, false. */
    public boolean search(String word) {
        TrieNode node = root;
        for(int i = 0; i < word.length(); i++) {
            int ind = word.charAt(i) - 'a';
            if(node.children[ind] == null) return false;
            node = node.children[ind];
        }
        return node.isWord;
    }
    
    /** Same as search just no need for isWord check at the end. */
    public boolean startsWith(String word) {
        TrieNode node = root;
        for(int i = 0; i < word.length(); i++) {
            int ind = word.charAt(i) - 'a';
            if(node.children[ind] == null) return false;
            node = node.children[ind];
        }
        return true;
    }
}
