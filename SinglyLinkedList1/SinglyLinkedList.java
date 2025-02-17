public class SinglyLinkedList {

    // Node class for linked list
    private class Node {
        int data;
        Node next;

        // Constructor to create a new node
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head; // Head of the list

    public SinglyLinkedList() {
        head = null;
    }

    // Insert element at the end of the list
    public void insert(int data) {
        Node newNode = new Node(data);
        
        // If the list is empty, make the new node the head
        if (head == null) {
            head = newNode;
            return;
        }

        // Traverse to the last node
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }

        // Add the new node at the end
        current.next = newNode;
    }

    // Insert element at the front of the list
    public void insertAtFront(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    // Delete a node by its value
    public void delete(int key) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        // If the node to be deleted is the head node
        if (head.data == key) {
            head = head.next;
            return;
        }

        // Search for the node to be deleted
        Node current = head;
        while (current.next != null && current.next.data != key) {
            current = current.next;
        }

        // If node is not found
        if (current.next == null) {
            System.out.println("Node with value " + key + " not found.");
            return;
        }

        // Skip the node to be deleted
        current.next = current.next.next;
    }

    // Display the elements in the list
    public void display() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    // Search for a node by its value
    public boolean search(int key) {
        Node current = head;
        while (current != null) {
            if (current.data == key) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();

        // Insert elements
        list.insert(10);
        list.insert(20);
        list.insert(30);

        // Display the list
        System.out.println("List after insertions:");
        list.display();  // Expected: 10 -> 20 -> 30 -> null

        // Insert at the front
        list.insertAtFront(5);
        System.out.println("List after inserting at front:");
        list.display();  // Expected: 5 -> 10 -> 20 -> 30 -> null

        // Delete a node
        list.delete(20);
        System.out.println("List after deleting node with value 20:");
        list.display();  // Expected: 5 -> 10 -> 30 -> null

        // Search for a value
        System.out.println("Is 10 in the list? " + list.search(10));  // Expected: true
        System.out.println("Is 20 in the list? " + list.search(20));  // Expected: false
    }
}
