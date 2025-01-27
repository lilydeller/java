/*
 * LILY DELLER
 */

// defining a class named Fruit representing a fruit object
class Fruit implements Comparable<Fruit> {
    // declaring a private member variables 'type' and 'weight' to store fruit type and weight
    private String type;
    private double weight;

    // defining a default constructor for the Fruit class
    public Fruit() {
        // initializing type to "apple" and weight to 1.0 by default
        this.type = "apple";
        this.weight = 1.0;
    }

    // defining a parameterized constructor for the Fruit class
    public Fruit(String type, double weight) {
        // checking if the specified fruit type is valid, if not, default to "apple"
        if (type.equalsIgnoreCase("apple") || type.equalsIgnoreCase("orange") ||
            type.equalsIgnoreCase("banana") || type.equalsIgnoreCase("kiwi") ||
            type.equalsIgnoreCase("tomato")) {
            this.type = type;
        } else {
            this.type = "apple";
        }
        // checking if the specified weight is positive, if not, default to 1.0
        if (weight > 0) {
            this.weight = weight;
        } else {
            this.weight = 1.0;
        }
    }

    // defining a method to get the type of the fruit
    public String getType() {
        return type;
    }

    // defining a method to set the type of the fruit
    public void setType(String type) {
        // checking if the specified fruit type is valid before setting it
        if (type.equalsIgnoreCase("apple") || type.equalsIgnoreCase("orange") ||
            type.equalsIgnoreCase("banana") || type.equalsIgnoreCase("kiwi") ||
            type.equalsIgnoreCase("tomato")) {
            this.type = type;
        }
    }

    // defining a method to get the weight of the fruit
    public double getWeight() {
        return weight;
    }

    // defining a method to set the weight of the fruit
    public void setWeight(double weight) {
        // checking if the specified weight is positive before setting it
        if (weight > 0) {
            this.weight = weight;
        }
    }

    // implementing the compareTo method from the Comparable interface to compare fruits
    @Override
    public int compareTo(Fruit other) {
        // comparing fruits based on their weights and types
        if (this.weight > other.weight) {
            return 1;
        } else if (this.weight < other.weight) {
            return -1;
        } else {
            return this.type.compareTo(other.type);
        }
    }

    // override the toString method to provide a string representation of the fruit object
    @Override
    public String toString() {
        return "Type: " + type + " Weight: " + weight;
    }
}

// defining a class named Node representing a node in a binary tree
class Node<T extends Comparable<T>> {
    // declaring member variables 'data', 'left', and 'right' to store node data and references
    T data;
    Node<T> left, right;

    // defining a constructor for the Node class
    public Node(T data) {
        // initializing the node with the given data and set left and right references to null
        this.data = data;
        left = right = null;
    }
}
