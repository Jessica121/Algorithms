import java.util.*;
public class WordSearchII {
    /*
    i would say DFS on the first glimpse.
    for each neibor, add it to the visited and do dfs, then remove it.
    pass index and string, when index == end of the string, add the string to the result as it is found. :]
    but have to recognize the start of each word. for each word, find ?
    
    */
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        Arrays.sort(words);
        boolean found = false;
        for(int k = 0; k < words.length; k++) {
            if(k > 0 && words[k].equals(words[k - 1])) continue;
            found = false;
            for(int i = 0; i < board.length; i++) {
                if(found) break;
                for(int j = 0; j < board[0].length; j++) {
                    if(board[i][j] == words[k].charAt(0)) {
                        if(dfs(0, board, i, j, new boolean[board.length][board[0].length], words[k])) {
                            res.add(words[k]);
                            found = true;
                            break;
                        }
                    }
                }
            }
        }
        return res;
    }
    
    private boolean dfs(int index, char[][] board, int row, int col, boolean[][] visited, String word) {
        if(index == word.length()) return true;
        if(row < 0 || col < 0 || row >= board.length || col >= board[0].length || visited[row][col]) return false;
        if(board[row][col] != word.charAt(index)) return false;
        visited[row][col] = true;
        if(dfs(index + 1, board, row + 1, col, visited, word) || dfs(index + 1, board, row - 1, col, visited, word) || 
           dfs(index + 1, board, row, col + 1, visited, word) || dfs(index + 1, board, row, col - 1, visited, word)) return true;
        visited[row][col] = false;
        return false;
    }
    
    /*
     * 
     * To check the multiple beginning of words, use trie.
    use a trie to collect the words in the dict.
    iterating the 2D matrix, if exists the child under the root, search in that node until met isword.
    this might get tricky when one branch has multiple words, so needs to keep tracking until reach null.
    node, cell in the board, check all its children, if exist in that index, if so, that child node is passed on and all four dfs are involved.
    check node has the child in the char[i][j] or not, if so, do dfs in four directions pass on the child root. if not, return false.
    if node is word, not empty, return its value.
    
    */
    public List<String> findWordsTire(char[][] board, String[] words) {
        TrieNode root = new TrieNode();
        buildTrie(root, words);
        List<String> res = new ArrayList<>();
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                int index = board[i][j] - 'a';
                if(root.children[index] != null) {
                    dfs(root, board, i, j, new boolean[board.length][board[0].length], res);
                }
            }
        }
        return res;
    }
    
    private void dfs(TrieNode root, char[][] board, int row, int col, boolean[][] visited, List<String> res) {
    	// like said before, if in the middle of the branch there is a word, add it and continue to BFS, not return!
        if(!root.word.isEmpty() && !res.contains(root.word)) res.add(root.word);
        if(row < 0 || col < 0 || row >= board.length || col >= board[0].length || visited[row][col]) return;
        int index = board[row][col] - 'a';
        // when find does not have the children, return, this is done before setting current cell visited to true.
        if(root.children[index] == null) return;
        visited[row][col] = true;
        int[] dir = {-1, 0, 1, 0, -1};
        for(int i = 0; i < dir.length - 1; i++) {
        	// give the parent node, visit neibors, check whichever it contains the neibor as the child. may have different val in nei.
            dfs(root.children[index], board, row + dir[i], col + dir[i + 1], visited, res);
        }
        visited[row][col] = false;
    }
    
    private void buildTrie(TrieNode root, String[] words) {
        for(String word : words) insert(root, word);
    }
    
    private void insert(TrieNode node, String word) {
        for(int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if(node.children[index] == null) node.children[index] = new TrieNode();
            node = node.children[index];
        }
        node.word = word;
    }
    
    class TrieNode {
        String word;
        TrieNode[] children;
        public TrieNode() {
            this.word = "";
            this.children = new TrieNode[26];
        }
    }
}
