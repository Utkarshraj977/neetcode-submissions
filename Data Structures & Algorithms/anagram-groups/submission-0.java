
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        
        for (String s : strs) {
           char[] chars = s.toCharArray();
           Arrays.sort(chars);
           String k = new String(chars);
           
           map.putIfAbsent(k, new ArrayList<String>());
           map.get(k).add(s);
        }
    
        return new ArrayList<>(map.values());
    }
}
