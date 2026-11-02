class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> l=new ArrayList<>();
        int n=nums.length;
        Arrays.sort(nums);
        for(int i=0;i<n-2;i++){
            if(i>0 && nums[i]==nums[i-1]) continue;
            int le=i+1;
            int r=n-1;
            while(le<r){
                int sum=nums[i]+nums[le]+nums[r];
                if(sum==0){
                    l.add(Arrays.asList(nums[i],nums[le],nums[r]));
                    while(le<r && nums[le]==nums[le+1]) le++;
                    while(le<r && nums[r]==nums[r-1]) r--;
                    le++;
                    r--;
                }else if(sum<0){
                    le++;
                }else{
                    r--;
                }
            }
        }
        return l;
    }
}
