/*
 * LILY DELLER
 */

// defining a class named LinkedBST via assignment guidelines
class LinkedBST<T extends Comparable<T>> {
    // defining a private member variable 'root' of type Node<T>
    private Node<T> root;

    // a constructor for the LinkedBST class
    public LinkedBST() {
        // initializing 'root' to null
        root = null;
    }

    // our method to add data to the binary search tree
    public void add(T data) {
        // to call the private add method passing the root node and data
        root = add(root, data);
    }

    // private recursive method to add data to the binary search tree
    private Node<T> add(Node<T> node, T data) {
        // if the current node is null, create a new node with the given data
        if (node == null) {
            return new Node<>(data);
        }

        // to compare the given data with the data in the current node
        if (data.compareTo(node.data) < 0) {
            // if the given data is less than the current node's data, add it to the left subtree
            node.left = add(node.left, data);
        } else if (data.compareTo(node.data) > 0) {
            // if the given data is greater than the current node's data, add it to the right subtree
            node.right = add(node.right, data);
        }

        // to return the modified node
        return node;
    }

    // method to search for data in the binary search tree
    public boolean search(T data) {
        // calling the private search method passing the root node and data
        return search(root, data);
    }

    // private recursive method to search for data in the binary search tree
    private boolean search(Node<T> node, T data) {
        // if the current node is null, return false
        if (node == null) {
            return false;
        }

        // comparing the given data with the data in the current node
        if (data.compareTo(node.data) == 0) {
            // if the given data is equal to the current node's data, return true
            return true;
        } else if (data.compareTo(node.data) < 0) {
            // if the given data is less than the current node's data, search in the left subtree
            return search(node.left, data);
        } else {
            // if the given data is greater than the current node's data, search in the right subtree
            return search(node.right, data);
        }
    }

    // method to remove data from the binary search tree
    public void remove(T data) {
        // calling the private remove method passing the root node and data
        root = remove(root, data);
    }

    // private recursive method to remove data from the binary search tree
    private Node<T> remove(Node<T> node, T data) {
        // if the current node is null, return null
        if (node == null) {
            return null;
        }

        // comparing the given data with the data in the current node
        if (data.compareTo(node.data) < 0) {
            // if the given data is less than the current node's data, remove it from the left subtree
            node.left = remove(node.left, data);
        } else if (data.compareTo(node.data) > 0) {
            // if the given data is greater than the current node's data, remove it from the right subtree
            node.right = remove(node.right, data);
        } else {
            // if the given data is equal to the current node's data
            if (node.left == null) {
                // if the left child is null, return the right child
                return node.right;
            } else if (node.right == null) {
                // if the right child is null, return the left child
                return node.left;
            } else {
                // if both children are present
                // find the minimum node in the right subtree
                node.data = findMin(node.right).data;
                // remove the minimum node from the right subtree
                node.right = remove(node.right, node.data);
            }
        }
        // return the modified node
        return node;
    }

    //private method to find the minimum node in a subtree
    private Node<T> findMin(Node<T> node) {
        // transverse left until reaching the leftmost node
        if (node.left == null) {
            return node;
        }
        return findMin(node.left);
    }

    // defining a method to print the binary search tree in in-order traversal
    public void printInOrder() {
        // calling the private printInOrder method passing the root node
        printInOrder(root);
    }

    // defining a private recursive method to print the binary search tree in in-order traversal
    private void printInOrder(Node<T> node) {
        // if the current node is not null
        if (node != null) {
            // recursively print the left subtree
            printInOrder(node.left);
            // printing the data in the current node
            System.out.println(node.data);
            // recursively print the right subtree
            printInOrder(node.right);
        }
    }

    // method to print the binary search tree in pre-order traversal
    public void printPreOrder() {
        // calling the private printPreOrder method passing the root node
        printPreOrder(root);
    }

    // defining a private recursive method to print the binary search tree in pre-order traversal
    private void printPreOrder(Node<T> node) {
        // if the current node is not null
        if (node != null) {
            // printing the data in the current node
            System.out.println(node.data);
            // recursively print the left subtree
            printPreOrder(node.left);
            // recursively print the right subtree
            printPreOrder(node.right);
        }
    }

    // defining a method to print the binary search tree in post-order traversal
    public void printPostOrder() {
        // calling the private printPostOrder method passing the root node
        printPostOrder(root);
    }

    // defining a private recursive method to print the binary search tree in post-order traversal
    private void printPostOrder(Node<T> node) {
        // If the current node is not null
        if (node != null) {
            // recursively print the left subtree
            printPostOrder(node.left);
            // recursively print the right subtree
            printPostOrder(node.right);
            // printing the data in the current node
            System.out.println(node.data);
        }
    }
}
