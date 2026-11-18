class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int rst=0;int rend=matrix.length-1;int cst=0;int cend=matrix[0].length-1;
        List<Integer> ans=new ArrayList<>();

        while(rst<=rend && cst<=cend){
            if(cst<=cend){
                for(int i=cst;i<=cend;i++){
                    ans.add(matrix[rst][i]);
                }
                rst++;
            }
            if(rst<=rend){
                for(int i=rst;i<=rend;i++){
                    ans.add(matrix[i][cend]);
                }
                cend--;
            }
            if(cend>=cst && rst<=rend){
                for(int i=cend;i>=cst;i--){
                    ans.add(matrix[rend][i]);
                }
                rend--;
            }
            if(rend>=rst && cend>=cst){
                for(int i=rend;i>=rst;i--){
                    ans.add(matrix[i][cst]);
                }
                cst++;
            }
        }
        return ans;
    }
}
