import java.util.*;
public class LetterCombOfAPhoneNumber {
    /*
    each char in the digit, concat with element from queue, add back.
    hence need to know the size of queue before hand.
    for each element poll from the queue, concat with each char in digit.
    add back.
    goes for all digits.
    queue offer an empty string first.
    return the things left in the queue
    */
    public List<String> letterCombinations(String digits) {
        if(digits.isEmpty()) return new ArrayList<>();
        Queue<String> que = new LinkedList<>();
        que.offer("");
        for(int i = 0; i < digits.length(); i++) {
            String letters = getLetters(digits.charAt(i) - '0');
            int size = que.size();
            for(int j = 0; j < size; j++) {
                String prev = que.poll();
                for(int k = 0; k < letters.length(); k++) {
                    que.offer(prev + letters.charAt(k));
                }
            }
        }
        return new ArrayList(que);
    }
    
    private String getLetters(int i) {
        String[] arr = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        return arr[i];
    }
}
