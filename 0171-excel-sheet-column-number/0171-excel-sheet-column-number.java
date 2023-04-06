class Solution {
    public int titleToNumber(String columnTitle) {
        int result = 0;
        char[] chars = columnTitle.toCharArray();
        
        for (Character c : chars) {
            result = ((int)(c - 'A') + 1) + (result * 26);
        }
        
        return result;
    }
}