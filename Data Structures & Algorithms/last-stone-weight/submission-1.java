class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->(b-a));
        for(int n:stones){
            pq.add(n);
        }
        while(pq.size()>1){
            int h1=pq.remove();
            int h2=pq.remove();
            if(h1==h2){
                continue;
            }else if(h1 > h2){
                pq.add(h1-h2);
            }
        }
        return pq.size() == 1 ?  pq.remove() : 0;
    }
}
