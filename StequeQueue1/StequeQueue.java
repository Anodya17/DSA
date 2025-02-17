import java.util.LinkedList;
import java.util.Queue;

public class StequeQueue {
    private Queue<Integer> queue1;
    private Queue<Integer> queue2;

    public StequeQueue() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    // Push element to the front (like stack push)
    public void push(int x) {
        queue1.add(x);
    }

    // Enqueue element to the back (like queue enqueue)
    public void enqueue(int x) {
        queue2.add(x);
    }

    // Pop element from the front (like stack pop)
    public int pop() {
        if (queue1.isEmpty()) {
            throw new IllegalStateException("StequeQueue is empty");
        }

        // Remove the front element from queue1 (stack-like behavior)
        return queue1.poll();
    }

    // Dequeue element from the back (like queue dequeue)
    public int dequeue() {
        if (queue2.isEmpty()) {
            throw new IllegalStateException("StequeQueue is empty");
        }

        // Remove the front element from queue2 (queue-like behavior)
        return queue2.poll();
    }

    // Check if the StequeQueue is empty
    public boolean isEmpty() {
        return queue1.isEmpty() && queue2.isEmpty();
    }

    // Peek the front element of the StequeQueue
    public int peek() {
        if (queue1.isEmpty() && queue2.isEmpty()) {
            throw new IllegalStateException("StequeQueue is empty");
        }

        // If queue1 is not empty, peek at the front of queue1
        if (!queue1.isEmpty()) {
            return queue1.peek();
        } else {
            return queue2.peek(); // Otherwise peek at the front of queue2
        }
    }

    public static void main(String[] args) {
        StequeQueue stequeQueue = new StequeQueue();

        // Push elements (stack-like behavior)
        stequeQueue.push(10);
        stequeQueue.push(20);

        // Enqueue elements (queue-like behavior)
        stequeQueue.enqueue(30);
        stequeQueue.enqueue(40);

        System.out.println("Peek: " + stequeQueue.peek());  // Expected: 10 (front of queue1)

        // Pop element (stack-like pop)
        System.out.println("Popped element: " + stequeQueue.pop());  // Expected: 10

        // Dequeue element (queue-like dequeue)
        System.out.println("Dequeued element: " + stequeQueue.dequeue());  // Expected: 30

        // Peek again
        System.out.println("Peek after pop and dequeue: " + stequeQueue.peek());  // Expected: 20 (front of queue1)
    }
}