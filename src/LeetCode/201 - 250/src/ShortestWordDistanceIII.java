
public class ShortestWordDistanceIII {
    /*
    if equal, will always stop at equals word1. then cmp with d2 if not -1, and set d1. 
    add condition if two strings equal, make d2 = d1.
    d1, d2 = -1, -1.
    if string == wrd1, update d2, and - d1. save to res.
    else reverse.
    
    */
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int d1 = -1, d2 = -1, res = Integer.MAX_VALUE;
        for(int i = 0; i < words.length; i++) {
            if(words[i].equals(word1)) {
                d1 = i;
                if(d2 != -1) res = Math.min(res, i - d2);
                if(word1.equals(word2)) d2 = d1;
            } else if(words[i].equals(word2)) {
                d2 = i;
                if(d1 != -1) res = Math.min(res, i - d1);
            }
        }
        return res;
    }
}
