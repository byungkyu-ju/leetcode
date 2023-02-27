class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double maxAverage = Integer.MIN_VALUE;
        
        double tempAverage = 0;
        double sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            
            if (i >= k-1) { //sliding
                tempAverage = sum / k; 
                maxAverage = Math.max(maxAverage, tempAverage);
                sum = sum - nums[i-(k-1)];
            }
        }
        return maxAverage;
    }
}