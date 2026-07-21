class MinStack {
 Stack<Integer> st;
 Stack<Integer> minStack;

    public MinStack() {
        st = new Stack<Integer>();
        minStack = new Stack<Integer>();
       
    }
    
    public void push(int val) {
        st.push(val);
     if (minStack.isEmpty() || val <= minStack.peek()) {
        minStack.push(val);
    }
     }
    
    public void pop() {

     if (st.peek().equals(minStack.peek())) {
        minStack.pop();
    }

    st.pop();
        
     }
    
    public int top() {
       return st.peek();
        
    }
    
    public int getMin() {
        return minStack.peek();
        
    }
}
