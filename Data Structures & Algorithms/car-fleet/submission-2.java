class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        Stack<Double> st=new Stack<>();

        double[][] car=new double[position.length][2];
        for(int i=0;i<position.length;i++){
            car[i][0]=position[i];
            car[i][1]=(double)(target-position[i])/speed[i];
        }
        Arrays.sort(car,(a,b)->Double.compare(b[0],a[0]));
        int c=1;
        for(int i=0;i<car.length;i++){
            if(st.isEmpty()) st.push(car[i][1]);
            else if(car[i][1] > st.peek()){
                c++;
                System.out.println("t");
                st.push(car[i][1]);
            }
        }
        return c;
    }
}
