class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length==1) return true;
        int goal=nums.length-1;boolean ans=false;
        for(int i=nums.length-2;i>=0;i--){
            if(nums[i]+i>=goal){
                goal=i;
                ans=true;
            }else{
                ans=false;
            }
        }
        return ans;
    }
}
