import java.util.*;
public class PermutationSequence {
    /*
    k / previous permutation number + 1 is the index of the remaining candidates. and add to the res string
    then k % prev permutation number and previous purmutation number - 1.
    untill the permutation number is 0. add the last element into result.
    can use a treeset to store all the elements served as candidate
    save from 1, 2, ... n
    can calculate the permutation combnation of each n first.
    */
    public String getPermutation(int n, int k) {
        int[] permu = new int[n];
        calculatePermutation(permu);
        // System.out.println(Arrays.toString(permu));
        StringBuilder sb = new StringBuilder();
        List<Integer> list = new ArrayList<>();
        putInCandidates(list, n);
        while(n - 2 >= 0) {
            int index = (k - 1) / permu[n - 2];
            sb.append(list.get(index));
            list.remove(index);
            // k should substract index * permu[n - 2]
            k = k - index * permu[n - 2];
            n--;
        }
        sb.append(list.get(list.size() - 1));
        return sb.toString();
    }
    
    private void calculatePermutation(int[] arr) {
        arr[0] = 1;
        for(int i = 1; i < arr.length; i++) {
            arr[i] = arr[i - 1] * (i + 1);
        }
    }
    
    private void putInCandidates(List<Integer> list, int n) {
        for(int i = 1; i <= n; i++) list.add(i);
    }
}
