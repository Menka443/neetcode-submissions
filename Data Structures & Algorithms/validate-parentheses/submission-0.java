class Solution {

    public boolean isValid(String s) {

        Stack<Character> st = new Stack<Character>();

         for(char ch : s.toCharArray()){
             // Push opening brackets
            if(ch == '(' || ch == '{' || ch == '['){
            st.push(ch);

             // Closing bracket
           } else {

                // Stack should not be empty
                if (st.isEmpty()) {
                    return false;
                }
                char top = st.pop();

                  // Check matching pair
                  if(ch == ')' && top != '(' ||
                     ch == '}' && top != '{' ||
                     ch == ']' && top != '['){
                    return false;
                  }

         }
         }

        // If stack is empty, all brackets matched
        return st.isEmpty();
        
    }
}
