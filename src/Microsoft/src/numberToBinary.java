
public class numberToBinary {
    /*
    int to bianry
    use the same logic, for e.g. 1010101
    append to the front & 1 result, and logic right shift by 1.
    corner case: input is 0.
    
    */
    public String toHex(int num) {
        if(num == 0) return "0";
        StringBuilder sb = new StringBuilder();
        while(num != 0) {
            sb.insert(0, num & 1);
            num >>>= 1;
        }
        return sb.toString();
    }
}
