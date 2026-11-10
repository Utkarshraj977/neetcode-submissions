class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st=new Stack<>();
        for(String ch:tokens){
            if(ch.equals("+") || ch.equals("-") || ch.equals("*") || ch.equals("/")){
                int n2=st.pop();
                int n1=st.pop();
                int res=switch(ch){
                    case "+" -> n1+n2;
                    case "-" -> n1-n2;
                    case "*" -> n1*n2;
                    case "/" -> n1/n2;
                    default -> 0;
                };
                st.push(res);
            }else{
                int data=Integer.parseInt(ch);
                st.push(data);
            }
        }
        return st.pop();
    }
}
