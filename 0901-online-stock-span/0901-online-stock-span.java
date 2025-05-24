import java.util.Stack;

class StockSpanner {    
    private Stack<int[]> st; // Stack to store pairs of (price, index)
    private int index; // To keep track of the current index (day)
    
    public StockSpanner() {
        st = new Stack<>();
        index = -1; // Start from -1 as we will increment at the start of the next call
    }

    public int next(int price) {
        index++; // Increment day index
        
        // Pop elements from the stack while the stack is not empty and the top element is less than or equal to the current price
        while (!st.isEmpty() && price >= st.peek()[0]) {
            st.pop();
        }

        // Calculate the span
        int span;
        if (st.isEmpty()) {
            span = index + 1; // If the stack is empty, span is the current index + 1
        } else {
            span = index - st.peek()[1]; // Else, it's the difference between current index and the index on top of the stack
        }
        
        // Push the current price and index as a pair onto the stack
        st.push(new int[]{price, index});

        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
