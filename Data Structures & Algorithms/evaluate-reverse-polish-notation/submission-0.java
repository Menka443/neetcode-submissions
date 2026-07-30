// import java.util.Stack;

class Solution {

    public int evalRPN(String[] tokens) {

        Stack<Integer> st = new Stack<>();

        for(int i = 0; i < tokens.length; i++) {

            String token = tokens[i];

            if(!token.equals("+") && 
               !token.equals("-") && 
               !token.equals("*") && 
               !token.equals("/")) {

                st.push(Integer.parseInt(token));

            } else {

                int a = st.pop();
                int b = st.pop();

                int result = 0;

                if(token.equals("+")) {
                    result = b + a;
                }
                else if(token.equals("-")) {
                    result = b - a;
                }
                else if(token.equals("*")) {
                    result = b * a;
                }
                else if(token.equals("/")) {
                    result = b / a;
                }

                st.push(result);
            }
        }

        return st.peek();
    }
}