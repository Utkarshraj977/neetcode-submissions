class Solution {
    public int longestConsecutive(int[] nums) {
        int n=nums.length;
        if(n==1 || n==0) return n;
        HashSet<Integer> s=new HashSet<>();

        int ans=1;
        for(int i=0;i<n;i++){
           s.add(nums[i]);
        }
        for(int i=0;i<n;i++){
            if(s.contains(nums[i]-1)) continue;
            int max=1;
            int k=nums[i]+1;
            while(s.contains(k)){
                max++;
                k=k+1;
            }
            ans=Math.max(ans,max);
        }
        return ans;
    }
}
