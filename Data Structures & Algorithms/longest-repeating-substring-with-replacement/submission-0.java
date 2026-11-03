class Solution {
    public int characterReplacement(String s, int k) {
        int fre[]=new int[26];
        int l=0;int maxfre=0;int ans=0;

        for(int r=0;r<s.length();r++){
            fre[s.charAt(r)-'A']++;
            maxfre=Math.max(maxfre,fre[s.charAt(r)-'A']);

            while(l<r && r-l+1-maxfre > k){
                fre[s.charAt(l)-'A']--;
                l++;
            }
            ans=Math.max(ans,r-l+1);
        }
        return ans;
    }
}
