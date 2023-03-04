class Solution {
    public void reverseString(char[] s) {
        if (s.length == 1) {
            return;
        }
        
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length; i++) {
            stack.push(s[i]);
        }
        
        for (int i = 0; i < s.length; i++) {
            s[i] = stack.pop();
        }
    }
}