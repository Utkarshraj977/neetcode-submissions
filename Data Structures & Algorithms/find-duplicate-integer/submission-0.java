class Solution {
    public int findDuplicate(int[] nums) {
        for(int n:nums){
            int ind=Math.abs(n)-1;
            if(nums[ind]<0) return ind+1;
            nums[ind]=-nums[ind];
        }
        return -1;
    }
}
