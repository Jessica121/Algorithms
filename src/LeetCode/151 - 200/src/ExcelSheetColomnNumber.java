
public class ExcelSheetColomnNumber {
    /*
    still want to do it recursively, (char - 'A' + 1) * 26 ^ index. + recursion next. lol
    or start from front, next one gonna, prev * 26 + self.
    so no recursion needed.
    
    */
    public int titleToNumber(String s) {
        int prev = 0;
        for(int i = 0; i < s.length(); i++) {
            prev = prev * 26 + (s.charAt(i) - 'A' + 1);
        }
        return prev;
    }
}
