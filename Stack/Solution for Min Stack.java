class MinStack {
    
    // int minidx, min, ridx;
    // List<Integer> stack;
    // Queue<Integer> Q;
    Stack<Long> S;
    long min;

    /** initialize your data structure here. */
    public MinStack() {
        S = new Stack<>();
        // minidx = -1;
        // ridx = -1;
        // stack = new ArrayList<>();
        // Q = new PriorityQueue<>();
    }
    
    public void push(int x) {
        if (S.isEmpty()) {
            S.push(0L);
            min = x;
        } else {
            long diff = x - min;
            S.push(diff);
            if (diff < 0) min = x;
        }
        // Q.offer(x);
        // stack.add(x);
        // ridx++;
    }
    
    public void pop() {
        // Q.remove(stack.remove(ridx--));
        long rem = S.pop();
        if (rem < 0) {
            min = min - rem;
        }
    }
    
    public int top() {
        // return stack.get(ridx);
        long diff = S.peek();
        if (diff > 0) {
            return (int)(diff+min);
        } else {
            return (int)min;
        }
    }
    
    public int getMin() {
        // return Q.peek();
        return (int)min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */