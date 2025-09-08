class MinStack {
    Stack<Long> st = new Stack<Long>();
    Long mini;

    public MinStack() {
        mini = Long.MAX_VALUE;
        
    }
    
    public void push(int val) {
        Long value = Long.valueOf(val);
        if(st.isEmpty()){
            mini = value;
            st.push(value);
        }
        else{
            if(value < mini){
                st.push(2 * value - mini);
                mini = value;
            }
            else{
                st.push(value);
            }
        }
        
    }
    
    public void pop() {
        if(st.isEmpty()) return;
        Long value = st.pop();
        if(value < mini){
             mini = 2 * mini - value;
        }
        
    }
    
    public int top() {
        Long value = st.peek();
        if(value < mini){
            return mini.intValue();
        }
        return value.intValue();
        
    }
    
    public int getMin() {
        return mini.intValue();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */