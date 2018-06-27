
public class PlusOne {
    /*
    initilize an array of size + 1
    1 set as the flag. from the last digit, add to the number, carry on the flag
    num += flag
    flag = num / 10
    num = num % 10
    modify both the new and original array, 
    if first is 0, return the original array, else return new array
    */
    public int[] plusOne(int[] digits) {
        int[] arr = new int[digits.length + 1];
        int flag = 1;
        for(int i = digits.length - 1; i >= 0; i--) {
            int num = digits[i] + flag;
            arr[i + 1] = num % 10;
            digits[i] = num % 10;
            flag = num / 10;
        }
        if(flag == 1) {
            arr[0] = 1;
            return arr;
        } else return digits;
    }
}
