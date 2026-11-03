class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s2.length()<s1.length()) return false;
        HashSet<String> s=new HashSet<>();
        char ch[]=s1.toCharArray();
        Arrays.sort(ch);
        s.add(new String(ch));

        for(int l=0;l<=s2.length()-s1.length();l++){
            char[] c=s2.substring(l,l+s1.length()).toCharArray();
            Arrays.sort(c);
            if(s.contains(new String(c))) return true;
        }
        return false;
    }
}
