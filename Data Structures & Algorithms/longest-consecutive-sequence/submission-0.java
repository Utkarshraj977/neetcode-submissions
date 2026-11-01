class Solution {
    public int longestConsecutive(int[] nums) {
        int n=nums.length;
        if(n==1 || n==0) return n;
        Arrays.sort(nums);
        int max=1;int ans=1;
        for(int i=1;i<n;i++){
            if(nums[i]==nums[i-1]+1){
                max++;
                ans=Math.max(ans,max);
            }else if(nums[i]==nums[i-1]){
                continue;
            }else{
                max=1;
            }
        }
        return ans;
    }
}
