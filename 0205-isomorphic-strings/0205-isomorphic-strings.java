class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        
        Map<Character, Character> mapS = new HashMap<>();
        Map<Character, Character> mapT = new HashMap<>();
        
        for (int i = 0; i < s.length(); i++) {
            char target1 = s.charAt(i);
            char target2 = t.charAt(i);
            
            if (isUnpair(mapS, target1, target2) || isUnpair(mapT, target2, target1)) {
                return false;
            }
            
            mapS.put(target1, target2);
            mapT.put(target2, target1);
        }
        
        return true;
    }
    
    private boolean isUnpair(Map<Character, Character> map, char key, char value) {
        return map.containsKey(key) && map.get(key) != value;
    }
}