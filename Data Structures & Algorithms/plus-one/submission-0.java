class Solution {
    public int[] plusOne(int[] digits) {
        List<Integer> l = new ArrayList<>();
        int carry = 1;

        for (int i = digits.length - 1; i >= 0; i--) {
            int n = digits[i] + carry;
            l.add(n % 10);
            carry = n / 10;
        }

        if (carry > 0)
            l.add(carry);
        int[] res = new int[l.size()];
        for (int i = 0; i < l.size(); i++) {
            res[i] = l.get(l.size() - 1 - i);
        }
        return res;
    }
}
