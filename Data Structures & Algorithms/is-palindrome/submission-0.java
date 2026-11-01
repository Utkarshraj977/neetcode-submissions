class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb=new StringBuilder();
        for(char c:s.toCharArray()){
            if(Character.isLetterOrDigit(c)){
                sb.append(c);
            }
        }
        
        String si=sb.toString().toLowerCase();

        int n=sb.length();
        for(int i=0;i<n/2;i++){
            if(si.charAt(i) != si.charAt(n-i-1)) return false;
        }
        return true;
    }
}
