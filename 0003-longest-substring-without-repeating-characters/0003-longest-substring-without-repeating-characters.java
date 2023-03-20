class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] visited = new int[128];
        
        int left = 0;
        int right = 0;
        int result = 0;
        int length = s.length();
        while (right < length) {
            char c = s.charAt(right);
            if (visited[c] > 0) {
                left = Math.max(left, visited[c]);
            }
            visited[c] = right + 1;
            result = Math.max(result, right - left + 1);
            right++;
        }
        return result;
    }
}