class Solution {
    public boolean isHappy(int n) {
        
        HashSet<Integer> s = new HashSet<>();
        s.add(n);
        while (true) {
            int sum = helper(n);
            if (sum == 1)
                return true;
            else if(s.contains(sum)) return false;   
            s.add(sum);
            n=sum;
        }
    }
    private int helper(int n) {
        int sum = 0;
        while (n > 0) {
            int p=(n % 10);
            sum = sum+ (p*p);
            n /= 10;
        }
        return sum;
    }
}
