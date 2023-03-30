class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        
        String firstText = strs[0];
        String lastText = strs[strs.length -1];
        
        int idx = 0;
        while (idx < firstText.length() && idx < lastText.length()) {
            if (firstText.charAt(idx) == lastText.charAt(idx)) {
                idx++;
            } else {
                break;
            }
        }
                
        return firstText.substring(0, idx);
    }
}