class Solution {
    public int mostWordsFound(String[] sentences) {
        int result = 0;
        for (int i = 0; i < sentences.length; i++) {
            String[] temp = sentences[i].split(" ");
            result = Math.max(result, temp.length);
        }
        return result;
    }
}