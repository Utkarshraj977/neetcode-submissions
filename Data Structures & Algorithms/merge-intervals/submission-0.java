class Solution {
    public int[][] merge(int[][] intervals) {

        List<int[]> ans=new ArrayList<>();
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        int min=intervals[0][0];
        int max=intervals[0][1];

        for(int[] i:intervals){
            if(max < i[0]){
                ans.add(new int[]{min,max});
                min=i[0];
                max=i[1];
            }else{
                min=Math.min(min,i[0]);
                max=Math.max(max,i[1]);
            }
            
        }
        ans.add(new int[]{min,max});
        return ans.toArray(new int[ans.size()][]);
    }
}
