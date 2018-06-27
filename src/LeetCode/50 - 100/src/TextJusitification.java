
public class TextJusitification {
    /*
     * This is not a correct solutionl
    1. keep track of the blank space in each line, the current pointer in the array as well as in the building string.
    2. stop when the res is not enough for the next word, or it is the end of the array.
    3. justify when it has not reached the last word.
    4. insert when cannot fit the next word, start from i - 1 till max width, insert into blank spaces till index i - 2
    can use a integer list to track the blank space index
    
    */
    public List<String> fullJustify(String[] words, int maxWidth) {
        StringBuilder sb = new StringBuilder();
        int linePtr = 0, arrPtr = 0;
        List<Integer> blanks = new ArrayList<>();
        List<String> res = new ArrayList<>();
        while(arrPtr < words.length) {
            // System.out.println(arrPtr);
            if(maxWidth - linePtr >= words[arrPtr].length()) {
                sb.append(words[arrPtr]);
                linePtr += words[arrPtr++].length() + 1;
                blanks.add(sb.length());
                
                if(arrPtr == words.length) {
                    for(int i = blanks.size() - 2; i >= 0; i--) {
                        sb.insert(blanks.get(i), " ");
                    }
                    sb.append(generate(maxWidth - sb.length()));
                    res.add(sb.toString());
                    return res;
                } 

            } else {
                if(blanks.size() > 1) {
                    int blankCnt = maxWidth - sb.length();
                    int left = blankCnt % 2 != 0 ? blankCnt / (blanks.size() - 1) + 1 : blankCnt / (blanks.size() - 1);
                    int right = blankCnt / (blanks.size() - 1);
                    if(blanks.size() >= 2)  sb.insert(blanks.get(blanks.size() - 2), generate(right));
                    String leftSpaces = generate(left);
                    for(int i = blanks.size() - 3; i >= 0; i--) {
                        sb.insert(blanks.get(i), leftSpaces);
                    }
                } else sb.append(generate(maxWidth - sb.length()));
                
                    System.out.println(sb);
                res.add(sb.toString());
                linePtr = 0;
                blanks = new ArrayList<>();
                sb = new StringBuilder();
            } 
        }
        return res;
    }
    
    private String generate(int n) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) sb.append(' ');
        return sb.toString();
    }
}
