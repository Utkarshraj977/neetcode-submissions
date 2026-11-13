class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] arr=new int[26];
        for(int i=0;i<s.length();i++){
            arr[s.charAt(i)-'a']=i;
        }
        List<Integer> l=new ArrayList<>();
        int st=0;int e=0;
        for(int i=0;i<s.length();i++){
            e=Math.max(e,arr[s.charAt(i)-'a']);
            if(i==e) {
                l.add(e-st+1);
                st=i+1;
            }
        }
        return l;
    }
}
