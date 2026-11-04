class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int r=0;
        for(int p:piles) r=Math.max(r,p);
        int l=1;int ans=Integer.MAX_VALUE;
        while(l<=r){
            long max=0;
            int mid=l+(r-l)/2;
            for(int p:piles){
                max+=(((p-1)/mid)+1);
            }
            if(max <= h){
                ans=mid;
                r=mid-1;
            }
            else if(max > h) l=mid+1;
        }
        return ans;
    }
}
