public class BinarySearchTreeWithRecursive {

    // Node class representing each node in the tree
    static class Node {
        int value;
        Node left, right;

        Node(int value) {
            this.value = value;
            left = right = null;
        }
    }

    Node root;

    // Insert a value into the tree recursively
    public void insert(int value) {
        root = insertRecursively(root, value);
    }

    private Node insertRecursively(Node root, int value) {
        if (root == null) {
            return new Node(value);
        }
        if (value < root.value) {
            root.left = insertRecursively(root.left, value);
        } else if (value > root.value) {
            root.right = insertRecursively(root.right, value);
        }
        return root;
    }

    // In-order traversal (left, root, right) recursively
    public void inorderTraversal() {
        inorderTraversalRecursive(root);
        System.out.println();
    }

    private void inorderTraversalRecursive(Node root) {
        if (root != null) {
            inorderTraversalRecursive(root.left);
            System.out.print(root.value + " ");
            inorderTraversalRecursive(root.right);
        }
    }

    // Search for a value recursively
    public boolean search(int value) {
        return searchRecursive(root, value);
    }

    private boolean searchRecursive(Node root, int value) {
        if (root == null) {
            return false;
        }
        if (root.value == value) {
            return true;
        }
        return value < root.value
                ? searchRecursive(root.left, value)
                : searchRecursive(root.right, value);
    }

    // Delete a value recursively
    public void delete(int value) {
        root = deleteRecursive(root, value);
    }

    private Node deleteRecursive(Node root, int value) {
        if (root == null) {
            return null;
        }

        if (value < root.value) {
            root.left = deleteRecursive(root.left, value);
        } else if (value > root.value) {
            root.right = deleteRecursive(root.right, value);
        } else {
            // Node with only one child or no child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // Node with two children: get the inorder successor (smallest in the right subtree)
            root.value = findMinValue(root.right);

            // Delete the inorder successor
            root.right = deleteRecursive(root.right, root.value);
        }

        return root;
    }

    private int findMinValue(Node root) {
        return root.left == null ? root.value : findMinValue(root.left);
    }

    public static void main(String[] args) {
        BinarySearchTreeWithRecursive bst = new BinarySearchTreeWithRecursive();
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(20);
        bst.insert(40);
        bst.insert(60);
        bst.insert(80);

        System.out.println("In-order traversal:");
        bst.inorderTraversal();

        System.out.println("Search 40: " + bst.search(40));
        System.out.println("Search 90: " + bst.search(90));

        System.out.println("Delete 20");
        bst.delete(20);
        bst.inorderTraversal();

        System.out.println("Delete 30");
        bst.delete(30);
        bst.inorderTraversal();

        System.out.println("Delete 50");
        bst.delete(50);
        bst.inorderTraversal();
    }
}
