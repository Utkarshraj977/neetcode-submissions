class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int[] l=new int[n];
        int[] r=new int[n];
        l[0]=nums[0];
        r[n-1]=nums[n-1];
        for(int i=1;i<n;i++){
            l[i]=l[i-1]*nums[i];
        }
        for(int i=n-2;i>=0;i--){
            r[i]=r[i+1]*nums[i];
        }
        int ans[]=new int[n];
        for(int i=0;i<n;i++){
            if(i==0) ans[i]=r[i+1];
            else if(i==n-1) ans[i]=l[i-1];
            else
              ans[i]=l[i-1]*r[i+1];
        }
        return ans;
    }
}  
