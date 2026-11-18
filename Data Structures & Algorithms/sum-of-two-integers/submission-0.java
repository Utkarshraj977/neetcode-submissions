class Solution {
    public int getSum(int a, int b) {
        int r = 0;
        int ans = 0;

        for (int pos = 0; pos < 32; pos++) {
            int p = a & 1;
            int q = b & 1;

            int t = p ^ q;
            int sum = t ^ r;
            int cOut = (p & q) | (r & t);

            ans |= (sum << pos);
            r = cOut;
            a >>>= 1;
            b >>>= 1;
        }

        return ans;
    }
}
