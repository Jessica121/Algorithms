
public class FirstMissingPositive {
    /*
    for each value in the array, swap to its correct index (value - 1), provided that the value ranges from 1 to nums.length
    else put it to -1.
    keep swapping until the element is equal to its index - 1 or went out of bounds (set it to -1 and go on)
    if index == value, move on. else swap.before swapping, make sure the destination isnt already the value itself. if so go on.
    then go thru the index 1 (i == 1) stop when nums[i] != i this i is the number
    
    */
    public int firstMissingPositive(int[] nums) {
        int res = 0, i = 0;
        while(i < nums.length) {
            if(nums[i] == i + 1) i++;
            else if(nums[i] <= 0 || nums[i] > nums.length) nums[i++] = -1;
            else {
                if(nums[nums[i] - 1] != nums[i]) swap(nums, i, nums[i] - 1);
                else i++;
            }
        }
        while(res < nums.length) {
            if(nums[res] != res + 1) break;
            res++;
        }
        return res + 1;
    }
    
    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
