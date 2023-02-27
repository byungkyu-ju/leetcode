class Solution {
    public int[] getAverages(int[] nums, int k) {
        int[] result = new int[nums.length];
        if (k == 0) return nums;
        
        long sum = 0L;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            
            // - avg[6], avg[7], and avg[8] are -1 because there are less than k elements after each index.
            if (i < k || i > nums.length -k -1) {
                result[i] = -1;
            }
            
            if (i >= k*2) {
                result[i-k] = (int)(sum / (k*2 +1));
                sum = sum - nums[i - k*2]; //앞자리
            }
        }
        return result;
    }
}