class Solution {
    public int missingNumber(int[] nums) {
        int ans=0;
        for(int n:nums) ans+=n;
        return (nums.length*(nums.length+1)/2)-ans;
    }
}
