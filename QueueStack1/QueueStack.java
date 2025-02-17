import java.util.LinkedList;
import java.util.Queue;

public class QueueStack {
    private Queue<Integer> queue;

    public QueueStack() {
        queue = new LinkedList<>();
    }

    // Push element to the stack
    public void push(int x) {
        int size = queue.size();

        // Add the new element to the queue
        queue.add(x);

        // Move all the elements before the newly added element to the back of the queue
        for (int i = 0; i < size; i++) {
            queue.add(queue.remove());
        }
    }

    // Pop element from the stack
    public int pop() {
        if (queue.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return queue.remove();
    }

    // Peek the top element
    public int peek() {
        if (queue.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return queue.peek();
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public static void main(String[] args) {
        QueueStack stack = new QueueStack();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Top element: " + stack.peek());  // Expected: 30
        System.out.println("Popped element: " + stack.pop());  // Expected: 30
        System.out.println("Top element after pop: " + stack.peek());  // Expected: 20
    }
}