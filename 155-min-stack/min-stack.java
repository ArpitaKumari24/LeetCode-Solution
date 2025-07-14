class MinStack {

    private CasualStack elementsStack;
    private CasualStack minElementsStack;

    public MinStack() {
        this.elementsStack = new CasualStack();
        this.minElementsStack = new CasualStack();
    }
    
    public void push(int val) {
        elementsStack.push(val);
        if (minElementsStack.getNumberOfElements() == 0 || val <= minElementsStack.top()) {
            minElementsStack.push(val);
        }
    }
    
    public void pop() {
        if (elementsStack.top() == minElementsStack.top()) {
            minElementsStack.pop();
        }
        elementsStack.pop();
    }
    
    public int top() {
        return elementsStack.top();
    }
    
    public int getMin() {
        return minElementsStack.top();
    }
}

class CasualStack {

    private int[] storage;
    private int lastElementIndex = -1;

    public CasualStack() {
        this.storage = new int[8];
    }
    
    public void push(int val) {
        lastElementIndex += 1;
        this.storage[lastElementIndex] = val;
        if (lastElementIndex == storage.length - 1) {
            storage = Arrays.copyOf(storage, storage.length * 2);
        }
    }
    
    public void pop() {
        if (lastElementIndex < 0) return;
        storage[lastElementIndex] = 0;
        lastElementIndex -= 1;
    }
    
    public int top() {
        return storage[lastElementIndex];
    }

    public int getNumberOfElements() {
        return lastElementIndex + 1;
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