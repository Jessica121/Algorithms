
public class ExcelSheetColomnTitle {
    /*
    have an array for A to Z. stringbuilder append index at n / 26 - 1. then take the rest. until n <= 26.
    nope dont need an array for a to z, just cast a char: n / 26 - 1 + 'A'
    what if it is super large and the n / 26 > 26 ? i think it may be better to take the mod and substract the mod 
    i would like to recursively do it :]
    divide by 26, pass recursion, append to the result: mod by 26.
    this is actually the number offset by one.
    52 -> 51.
    */
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        char cha = 'A';
        if(n <= 26) cha += n - 1;
        else {
            sb.append(convertToTitle((n - 1) / 26));
            cha += (n - 1) % 26;
        }
        sb.append(cha);
        return sb.toString();
    }
}
