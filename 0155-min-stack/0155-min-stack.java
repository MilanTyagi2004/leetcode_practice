class MinStack {
    private Stack <Long> st;
    private long min;
    public MinStack() {
        st = new Stack<>();
        min = Long.MAX_VALUE;
    }
    
    public void push(int val) {
        long x = val;
        if(st.isEmpty()){
            st.push(x);
            min = x;
        }else{
            if(x>=min){
                st.push(x);
            }else{
                st.push(2*x-min);
                min= x;
            }
        }
    }
    
    public void pop() {
        if(st.isEmpty()){
            return;
        }
        long x = st.pop();
        if(x<min){
            min = 2*min-x;
        }
    }
    
    public int top() {
       long top = st.peek();
        if (top >= min) {
            return (int)top;
        } else {
            return (int)min;
        }
    }
    
    public int getMin() {
        return (int)min;
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