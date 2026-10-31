class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        
        for (String s : strs) {
            int fre[]=new int[26];
           for(char ch:s.toCharArray()){
              fre[ch-'a']++;
           }
           StringBuilder sb=new StringBuilder();
           for(int i=0;i<26;i++){
             sb.append(fre[i]);
             sb.append('*');
           }
           String k = sb.toString();
           
           map.putIfAbsent(k, new ArrayList<String>());
           map.get(k).add(s);
        }
    
        return new ArrayList<>(map.values());
    }
}
