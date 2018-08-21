
public class IntegerToEnglishWord {
    /*
    i can do this.
    have arrays of words for thousands, tys, tens, teens
    the numbers are divided in thousands. 
    have a function takes in less than thousand number, convert into string, 
    have a index pointing to which thousand unit it should be, and append to it. increase the counter.
    str = value + " " + unit[i] + " " + str
    and trim before return.
    
    for < 1000 part: e.g. 987
    if >= 100, / 100 take the front, append hundred, then return this + recursion % 100.
    same with <= 20 to 100, take the ty and return this + recurstion % 10.
    with < 10 < 20, return the teen.
    <= 10, return the ten.
    
    corner case: zero neg.
    
    unpassed corner cases: 50868, 1000000
    
    
    */
    
    private final String[] thousands = {"", "Thousand", "Million", "Billion"}, tys = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"}, teens = {"", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"}, tens = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten"};
    public String numberToWords(int num) {
        if(num == 0) return "Zero";
        int i = 0;
        StringBuilder sb = new StringBuilder();
        // 1
        while(num != 0) {
            String hundred = hundreds(num % 1000).trim();
            if(!hundred.isEmpty()) sb.insert(0, hundred + " " + thousands[i] + " "); // 1_Million_234_Thousand_567__
            i++;
            num /= 1000;
        }
        return sb.toString().trim();
    }
    
    // 713
    private String hundreds(int num) {
        if(num == 0) return "";
        if(num >= 100) {
            return tens[num / 100] + " Hundred " + hundreds(num % 100);
        } else if(num >= 20) {
            return tys[num / 10] + " " + hundreds(num % 10);
        } else if(num > 10) {
            return teens[num - 10];
        } else return tens[num];
    }
}
