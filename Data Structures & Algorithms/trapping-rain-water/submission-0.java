class Solution {
    public int trap(int[] height) {
        int n=height.length;
        if(n==1) return 0;
        int[] lmax=new int[n];
        int[] rmax=new int[n];
        int i=0;
        for(i=0;i<n;i++){
            if(i==0) lmax[0]=height[0];
            else lmax[i]=Math.max(lmax[i-1],height[i]);
        }
        for(i=n-1;i>=0;i--){
            if(i==n-1) rmax[i]=height[i];
            else rmax[i]=Math.max(rmax[i+1],height[i]);
        }
        int maxw=0;
        for(i=1;i<n-1;i++){
            int w=Math.min(lmax[i],rmax[i]);
            maxw+=(w-height[i]);
        }
        return maxw;
    }
}
