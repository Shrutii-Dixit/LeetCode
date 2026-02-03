import java.util.Stack;
class MinStack {
    Stack<Integer> Stack;
    Stack<Integer> MinStack;

    public MinStack() {
        Stack = new Stack<>();
        MinStack = new Stack<>();
    }
    
    public void push(int val) {
        Stack.push(val);
        if(MinStack.isEmpty() || MinStack.peek() >= val){
            MinStack.push(val);
        }
    }
    
    public void pop() {
        if(Stack.isEmpty()) return;
        if(MinStack.peek().equals(Stack.peek())){
            MinStack.pop();
        }
        Stack.pop();
    }
    
    public int top() {
        return Stack.peek();

    }
    
    public int getMin() {
        return MinStack.peek();
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