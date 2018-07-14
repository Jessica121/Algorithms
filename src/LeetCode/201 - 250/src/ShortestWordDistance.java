
public class ShortestWordDistance {
    /*
    mark anchor1 and anchor2 for word1 and word2.
    if equal wrd1 mark an1 and - an2 if not null or -1
    else check with wrd2 and do the same thing, but - an1.
    else continue.
    return the min got checked along the way
    
    corner case: word1 & / | word2 not in the dict. then the res will be MAX. we know it is a error code
    overflow? no.
    words empty. then MAX res as well.
    
    */
    public int shortestDistance(String[] words, String word1, String word2) {
        int an1 = -1, an2 = -1, res = Integer.MAX_VALUE;
        for(int i = 0; i < words.length; i++) {
            if(words[i].equals(word1)) {
                an1 = i;
                if(an2 != -1) res = Math.min(res, i - an2);
            } else if(words[i].equals(word2)) {
                an2 = i;
                if(an1 != -1) res = Math.min(res, i - an1);
            }
        }
        return res;
    }
}
