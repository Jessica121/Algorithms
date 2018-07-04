
public class CompareVersionNumber {
    /*
    use two pointers for each of the string, stop when ptr2 == '.'. extract the substr ptr1, ptr2
    if both empty, advance ptr1 to ptr2 + 1.
    if one of them empty, compare the other one is zero or not. if zero, advance ptr1 to ptr2 + 1 for both.
    else compare both of the value, if same advance ptr1 to ptr2 + 1.
    if one of them out of bound, check the other one to see if it contains non 0s, if so return necessary.
    if both out of bounds and did not return anything, then equal, return 0.
    
    */
    public int compareVersion(String version1, String version2) {
        int ptr11 = 0, ptr12 = 0, ptr21 = 0, ptr22 = 0;
        while(ptr12 < version1.length() || ptr22 < version2.length()) {
            while(ptr12 < version1.length() && version1.charAt(ptr12) != '.') ptr12++;
            while(ptr22 < version2.length() && version2.charAt(ptr22) != '.') ptr22++;
            String num1 = ptr12 > version1.length() ? "" : version1.substring(ptr11, ptr12);
            String num2 = ptr22 > version2.length() ? "" : version2.substring(ptr21, ptr22);
            int val1 = num1.isEmpty() ? 0 : Integer.valueOf(num1), val2 = num2.isEmpty() ? 0 : Integer.valueOf(num2);
            if(val1 == val2) {
                ptr11 = ptr12++ + 1;
                ptr21 = ptr22++ + 1;
            } else return val1 > val2 ? 1 : -1;
        }
        return 0;
    }
}
