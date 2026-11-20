class Solution {
    public int jump(int[] nums) {
        int jumps=0;
        int farthest=0;
        int curr_end=0;
        for(int i=0;i<nums.length-1;i++){
            farthest=Math.max(farthest,nums[i]+i);
            if(i==curr_end) {curr_end=farthest;jumps++;}
        }
        return jumps;
    }
}
