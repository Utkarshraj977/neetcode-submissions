class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length()) return false;
        
        int[] ch = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            ch[s1.charAt(i) - 'a']++;
        }
        
        int l = 0;
        for (int r = 0; r < s2.length(); r++) {
            ch[s2.charAt(r) - 'a']--;
            
            while (ch[s2.charAt(r) - 'a'] < 0) {
                ch[s2.charAt(l) - 'a']++;
                l++;
            }
            
            if (r - l + 1 == s1.length()) {
                return true;
            }
        }
        
        return false;
    }
}
