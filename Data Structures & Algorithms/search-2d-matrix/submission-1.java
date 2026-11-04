class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int l=0;int r=(matrix.length*matrix[0].length)-1;
        while(l<=r){
            int mid=(l+r)/2;
            int ro=mid/matrix[0].length;
            int co=mid%matrix[0].length;
            if(matrix[ro][co]==target) return true;
            else if(matrix[ro][co]>target) r=mid-1;
            else l=mid+1;
        }
        return false;
    }
}
