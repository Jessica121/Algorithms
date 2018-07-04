
public class MaxGap {
    /*
    use radix sort: sort from LSD to MSD
    take last index: num / 1 % 10:
    second last: num / 10 % 10, ...
    use a digit counter array to store the cnt of numbers in digit i is 0, 1, 2, ... 9.
    then add the cnt array cnt[i] += cnt[i - 1], to calculate the index. there might be multiple digits with same value: e.g. all is 5, it okay, when put back in place: decreament to get the correct index and for the next index.
    when put back in place, the important thing is to go backwards in the original array, as later ones meant to be put in later places. hence sorted.
    when put back in place, replace the array with the original one.
    division *= 10, do it again.
    could run 10 times max. as in MAX value.
    
    */
    public int maximumGap(int[] nums) {
        int[] cnt = null, temp = null;
        int res = 0, div = 1;
        for(int j = 0; j < 10; j++) {
            cnt = new int[10];
            temp = new int[nums.length];
            for(int num : nums) cnt[num / div % 10]++;
            for(int i = 1; i < 10; i++) cnt[i] += cnt[i - 1];
            for(int i = nums.length - 1; i >= 0; i--) temp[--cnt[nums[i] / div % 10]] = nums[i];
            nums = temp;
            div *= 10;
        }
        for(int i = 1; i < nums.length; i++) res = Math.max(res, nums[i] - nums[i - 1]);
        return res;
    }
}
