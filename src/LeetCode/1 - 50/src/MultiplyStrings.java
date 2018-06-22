import java.util.Arrays;

public class MultiplyStrings {
    /*
    use an array of length num1 + num2 to save results;
    keep a flag for multiple, a flag for adding.
    can go with the shorter one as the second but not necessary.
    use two pointers on the number strings, ont from last to front, while other one settle at one index. the settled index is the index to add to in the array. when multiply add the mul flag and update mul flag for next use. when add, use add flag and update add.
    then the add flag is one left after the operation, if it is one, set the first element one. 
    convert the array to string.
    
    */
    public String multiply(String num1, String num2) {
        int[] arr = new int[num1.length() + num2.length()];
        int mul = 0, add = 0;
        for(int i = num2.length() - 1; i >= 0; i--) {
            for(int j = num1.length() - 1; j >= 0; j--) {
                int multi = (num2.charAt(i) - '0') * (num1.charAt(j) - '0') + mul;
                mul = multi / 10;
                int added = arr[i + j + 1] + add + multi % 10;
                arr[i + j + 1] = added % 10;
                add = added / 10;
            }
            // so when num1 ran out, the multiply flag need to be added to the index i 
            int flags = mul + add + arr[i];
            arr[i] = flags % 10;
            mul = 0;
            add = 0;
            // if the multiply flag rsultsfurther in more flags, continue to set it.
            if(flags / 10 == 1) arr[i - 1] = 1; // i - 1 >= 0
        }
        String res = Arrays.toString(arr).replaceAll(", |\\[|\\]", "");
        int i = 0;
        // the last zero should be left.
        while(i < res.length() - 1 && res.charAt(i) == '0') i++;
        return res.substring(i);
    }
    
    /*
    Similar to the one add list, add the flag to the front. if result further flag, IGRNOE IT, thats right, let it be 10 in one cell. fear me
    if it is the last calculataion, it will not be wrong. else next calculation will take care of it, genious!
    so for each multiplication, add the arr i + j + 1 and the result together, update the i + j + 1 cell.
    the flag add to previous cell i + j, if exceed 10, let it be.
    next one will take care of it.
    */
    public String multiplySmart(String num1, String num2) {
        int[] arr = new int[num1.length() + num2.length()];
        for(int i = num1.length() - 1; i >= 0; i--) {
            for(int j = num2.length() - 1; j >= 0; j--) {
                int mul = arr[i + j + 1] + (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                arr[i + j + 1] = mul % 10;
                arr[i + j] += mul / 10;
            }
        }
        String res = Arrays.toString(arr).replaceAll(", |\\[|\\]", "");
        int i = 0;
        while(i < res.length() - 1 && res.charAt(i) == '0') i++;
        return res.substring(i);
    }
}
