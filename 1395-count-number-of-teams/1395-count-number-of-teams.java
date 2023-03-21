class Solution {
    public int numTeams(int[] rating) {
        int result = 0;
        int length = rating.length;
        
        for (int mid = 0; mid < length; mid++) {
            int leftSmall = 0;
            int leftLarge = 0;
            int rightSmall = 0;
            int rightLarge = 0;
            
            for (int left = 0; left < mid; left++) {
                if (rating[left] < rating[mid]) {
                    leftSmall++;
                }else {
                    leftLarge++;
                }
            }
            
            for (int right = mid + 1; right < length; right++) {
                if (rating[right] < rating[mid]) {
                    rightSmall++;
                }else {
                    rightLarge++;
                }
            }
            result += (leftSmall * rightLarge) + (leftLarge * rightSmall);
        }
        
        return result;
    }
}