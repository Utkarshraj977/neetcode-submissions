class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";
        
        int[] ch = new int[128];
        for (int i = 0; i < t.length(); i++) {
            ch[t.charAt(i)]++;
        }
        
        int l = 0;
        int count = 0;
        int minLen = Integer.MAX_VALUE;
        int startIdx = 0;
        
        for (int r = 0; r < s.length(); r++) {
            char rChar = s.charAt(r);
            if (ch[rChar] > 0) {
                count++;
            }
            ch[rChar]--;
            
            while (count == t.length()) {
                if (r - l + 1 < minLen) {
                    minLen = r - l + 1;
                    startIdx = l;
                }
                
                char lChar = s.charAt(l);
                ch[lChar]++;
                if (ch[lChar] > 0) {
                    count--;
                }
                l++;
            }
        }
        
        return minLen == Integer.MAX_VALUE ? "" : s.substring(startIdx, startIdx + minLen);
    }
}
