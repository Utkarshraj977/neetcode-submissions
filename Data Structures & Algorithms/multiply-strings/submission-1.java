class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";
        if (num2.length() > num1.length()) return multiply(num2, num1);
        
        StringBuilder ans = new StringBuilder();

        for (int i = num2.length() - 1; i >= 0; i--) {
            StringBuilder m = mul(num1, num2.charAt(i), num2.length() - 1 - i);
            add(m, ans);
        }
        return ans.toString();
    }

    private StringBuilder mul(String num1, char b, int zeros) {
        StringBuilder t = new StringBuilder();
        int carry = 0;
        
        for (int j = num1.length() - 1; j >= 0; j--) {
            char ch = num1.charAt(j);
            int res = (ch - '0') * (b - '0') + carry;
            t.append(res % 10);
            carry = res / 10;
        }
        if (carry > 0) {
            t.append(carry);
        }
        
        t.reverse();
        while (zeros > 0) {
            t.append(0);
            zeros--;
        }
        return t;
    }

    private void add(StringBuilder m, StringBuilder ans) {
        char[] t1 = ans.toString().toCharArray();
        char[] t2 = m.toString().toCharArray();
        
        ans.setLength(0);
        
        int carry = 0;
        int i = t1.length - 1;
        int j = t2.length - 1;
        
        while (i >= 0 || j >= 0 || carry > 0) {
            int d1 = (i >= 0) ? (t1[i--] - '0') : 0;
            int d2 = (j >= 0) ? (t2[j--] - '0') : 0;
            
            int res = d1 + d2 + carry;
            ans.append(res % 10);
            carry = res / 10;
        }
        
      
        ans.reverse();
    }
}
