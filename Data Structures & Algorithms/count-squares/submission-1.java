class CountSquares {
    List<int[]> points;
    int[][] freq;
    public CountSquares() {
        points=new ArrayList<>();
        freq=new int[1001][1001];
    }
    
    public void add(int[] point) {
        points.add(point);
        freq[point[0]][point[1]]++;
    }
    
    public int count(int[] point) {
        int x=point[0];int y=point[1];
        int ans=0;
        for(int[] t:points){
            int x3=t[0];
            int y3=t[1];
            if(Math.abs(x-x3)==0 || Math.abs(x-x3)!=Math.abs(y-y3) ) continue;

            
            ans+= (freq[x][y3]*freq[x3][y]);
        }
        return ans;
    }
}