class Solution {
    public boolean isNStraightHand(int[] hand, int groupsize) {
        if(hand.length%groupsize != 0) return false;

        HashMap<Integer,Integer> map=new HashMap<>();
        Arrays.sort(hand);
        for(int h:hand){
            map.put(h,map.getOrDefault(h,0)+1);
        }

        for(int card:hand){
            if(map.get(card)==0) continue;
            for(int i=0;i<groupsize;i++){
                int currcard=card+i;
                int freq=map.getOrDefault(currcard,0);
                if(freq==0){
                    return false;
                }
                map.put(currcard,freq-1);
            }
        }
        return true;
    }
}
