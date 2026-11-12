class Solution {
    public int reverseBits(int n) {
        int res=0;int i=0;
        while(n!=0){
            if((n & 1) ==1){
                res |= (1<<(31-i));
            }
            i++;
            n=n>>>1;
        }
        return res;
    }
}
