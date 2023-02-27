class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int startIdx = 0;
        int sum = 0;
        int minimalLength = Integer.MAX_VALUE;
        
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            
            while (sum >= target) {
                minimalLength = Math.min(minimalLength, (i - startIdx) + 1);
                sum -= nums[startIdx];
                startIdx++;
            }
            
        }
        
        if (minimalLength == Integer.MAX_VALUE) {
            return 0;
        }
        return minimalLength;
    }
}
