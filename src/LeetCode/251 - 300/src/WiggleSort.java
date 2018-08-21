
public class WiggleSort {
    /*
    the thinking is, i % 2 == 0, i + 1 >= self. else <= self.
    if not, swap i with i + 1.
    if i % 2 == 0 swap, means i + 1 < self, after swap i + 1 > self, and i - 1 should >= self. but self gets lesser than its originally was, so its cool.
    same with even index.
    
    */
    public void wiggleSort(int[] nums) {
        for(int i = 0; i < nums.length - 1; i++) {
            if(i % 2 == 0 && nums[i + 1] < nums[i]) swap(nums, i, i + 1);
            else if(i % 2 == 1 && nums[i + 1] > nums[i]) swap(nums, i, i + 1);
        }
    }
    
    private void swap(int[] nums, int a, int b) {
        int t = nums[a];
        nums[a] = nums[b];
        nums[b] = t;
    }
}
