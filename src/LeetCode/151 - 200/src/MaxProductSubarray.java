
public class MaxProductSubarray {
    /*
    personally i think not much of a difference of the subarray sum one.
    mul with prev, if bigger than itself alone, mul to it. else update the prev and keep self as prev
    nope it could be neg makes it smaller and another neg makes it bigger. so cannot partially see the problem.
    
    it really comes down to prev pos and prev neg and res.
    if pos, mul to prev pos and update, mul to prev neg if it exist, make prev neg smaller.
    if neg, mul to prev neg, to update the res, compared to prev pos. and mul to prev pos create prev neg start now.
    update the result along the go as it can start anywhere.
    
    */
    public int maxProduct(int[] nums) {
        int res = Integer.MIN_VALUE, pos = 1, neg = 1;
        for(int num : nums) {
            if(num >= 0) {
            	// since there exist a zero possibility so have to check max.
                pos = Math.max(pos * num, num);
                neg *= num;
            } else {
                int oriNeg = neg;
                neg = Math.min(num, pos * num);
                pos = oriNeg * num;
            }
            res = Math.max(res, pos);
            if(neg >= 0) neg = 1;
            if(pos < 0) pos = 1;
        }
        return res;
    }
}
