class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> l = new Stack<>();
        Stack<Integer> star = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '*')
                star.push(i);
            else if (ch == '(')
                l.push(i);
            else if (!l.isEmpty() && ch == ')')
                l.pop();
            else if (!star.isEmpty() && (ch == ')'))
                star.pop();
            else
                return false;
        }
        while (!l.isEmpty() && !star.isEmpty() && l.peek() < star.peek()) {
            
                l.pop();
                star.pop();
            
        }
        return l.isEmpty() == true;
    }
}
