import java.util.ArrayList;

public class ArrayListExample {
    public static void main(String[] args) {
        // Create an ArrayList of integers
        ArrayList<Integer> numbers = new ArrayList<>();

        // Add elements to the ArrayList
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);
        numbers.add(40);
        numbers.add(50);

        // Display the ArrayList
        System.out.println("ArrayList: " + numbers);

        // Insert an element at index 2
        numbers.add(2, 25);
        System.out.println("After inserting 25 at index 2: " + numbers);

        // Remove an element by index
        numbers.remove(3);
        System.out.println("After removing element at index 3: " + numbers);

        // Get an element at a specific index
        int value = numbers.get(2);
        System.out.println("Element at index 2: " + value);

        // Update an element at index 1
        numbers.set(1, 15);
        System.out.println("After updating index 1 to 15: " + numbers);

        // Check if the ArrayList contains a specific value
        boolean contains40 = numbers.contains(40);
        System.out.println("Does the list contain 40? " + contains40);

        // Get the size of the ArrayList
        System.out.println("Size of the ArrayList: " + numbers.size());

        // Check if the ArrayList is empty
        System.out.println("Is the ArrayList empty? " + numbers.isEmpty());
    }
}
