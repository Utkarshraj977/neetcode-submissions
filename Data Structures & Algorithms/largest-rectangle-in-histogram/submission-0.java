class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st=new Stack<>();
        int max=0;
        int n=heights.length;
        for(int i=0;i<=n;i++){
            int currheight= (i==n) ? 0 : heights[i];
            while(!st.isEmpty() && heights[st.peek()] > currheight){
                int h=heights[st.pop()];
                int w=st.isEmpty() ? i : i-1-st.peek();
                max=Math.max(max,h*w);
            }
            st.push(i);
        }
        return max;
    }
}
