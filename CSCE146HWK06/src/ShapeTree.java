/*
 * LILY DELLER
 */
import java.io.*;
import java.util.Scanner;

// our shape class representing a shape node in the binary search tree
class ShapeNode {
    String type; // type of shape
    double area; // area of the shape
    ShapeNode left, right; // left and right children

    // our constructor
    public ShapeNode(String type, double area) {
        this.type = type;
        this.area = area;
        left = right = null;
    }
}

// our binary search Tree for storing shapes
class ShapeBST {
    private ShapeNode root; // Root node of the BST

    // constructor
    public ShapeBST() {
        root = null;
    }

    // insert a shape into the BST
    public void insert(String type, double area) {
        root = insertRecursive(root, type, area);
    }

    // recursive method to insert a shape into the BST
    private ShapeNode insertRecursive(ShapeNode node, String type, double area) {
        if (node == null) {
            return new ShapeNode(type, area);
        }
        if (area < node.area || (area == node.area && type.compareTo(node.type) < 0)) {
            node.left = insertRecursive(node.left, type, area);
        } else if (area > node.area || (area == node.area && type.compareTo(node.type) > 0)) {
            node.right = insertRecursive(node.right, type, area);
        }
        return node;
    }

    // remove a shape from the BST
    public void remove(String type, double dimension1, double dimension2) {
        root = removeRecursive(root, type, dimension1, dimension2);
    }

    // recursive method to remove a shape from the BST
    private ShapeNode removeRecursive(ShapeNode node, String type, double dimension1, double dimension2) {
        if (node == null) {
            return null; // shape not found
        }
        if (type.compareTo(node.type) < 0 || (type.equals(node.type) && dimension1 < node.area)) {
            node.left = removeRecursive(node.left, type, dimension1, dimension2);
        } else if (type.compareTo(node.type) > 0 || (type.equals(node.type) && dimension1 > node.area)) {
            node.right = removeRecursive(node.right, type, dimension1, dimension2);
        } else {
            // shape found
            if (node.type.equals("Rectangle")) {
                if (node.area == dimension1 * dimension2) {
                    if (node.left == null && node.right == null) {
                        return null; // no child case
                    }
                    if (node.left == null) {
                        return node.right; // one child case
                    }
                    if (node.right == null) {
                        return node.left; // one child case
                    }
                    // two children case
                    ShapeNode minRight = findMin(node.right);
                    node.area = minRight.area;
                    node.type = minRight.type;
                    node.right = removeRecursive(node.right, minRight.type, minRight.area, 0);
                }
            } else if (node.type.equals("Circle")) {
                if (node.area == Math.PI * dimension1 * dimension1) {
                    if (node.left == null && node.right == null) {
                        return null; // no child case
                    }
                    if (node.left == null) {
                        return node.right; // one child case
                    }
                    if (node.right == null) {
                        return node.left; // one child case
                    }
                    // two children case
                    ShapeNode minRight = findMin(node.right);
                    node.area = minRight.area;
                    node.type = minRight.type;
                    node.right = removeRecursive(node.right, minRight.type, minRight.area, 0);
                }
            } else if (node.type.equals("Right Triangle")) {
                if (node.area == 0.5 * dimension1 * dimension2) {
                    if (node.left == null && node.right == null) {
                        return null; // no child case
                    }
                    if (node.left == null) {
                        return node.right; // one child case
                    }
                    if (node.right == null) {
                        return node.left; // one child case
                    }
                    // two children case
                    ShapeNode minRight = findMin(node.right);
                    node.area = minRight.area;
                    node.type = minRight.type;
                    node.right = removeRecursive(node.right, minRight.type, minRight.area, 0);
                }
            }
        }
        return node;
    }

    // to find the minimum shape in the subtree rooted at node
    private ShapeNode findMin(ShapeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    // search for a shape in the BST
    public boolean search(String type, double dimension1, double dimension2) {
        return searchRecursive(root, type, dimension1, dimension2);
    }

    // recursive method to search for a shape in the BST
    private boolean searchRecursive(ShapeNode node, String type, double dimension1, double dimension2) {
        if (node == null) {
            return false;
        }
        if (type.equals(node.type)) {
            if (node.type.equals("Rectangle")) {
                if (node.area == dimension1 * dimension2) {
                    return true;
                }
            } else if (node.type.equals("Circle")) {
                if (node.area == Math.PI * dimension1 * dimension1) {
                    return true;
                }
            } else if (node.type.equals("Right Triangle")) {
                if (node.area == 0.5 * dimension1 * dimension2) {
                    return true;
                }
            }
        }
        if (type.compareTo(node.type) < 0 || (type.equals(node.type) && dimension1 < node.area)) {
            return searchRecursive(node.left, type, dimension1, dimension2);
        } else {
            return searchRecursive(node.right, type, dimension1, dimension2);
        }
    }

    // find the shape with the maximum area
    public ShapeNode findMax() {
        return findMaxRecursive(root);
    }

    // recursive method to find the shape with the maximum area
    private ShapeNode findMaxRecursive(ShapeNode node) {
        if (node == null) {
            return null;
        }
        if (node.right == null) {
            return node;
        }
        return findMaxRecursive(node.right);
    }

    // remove all shapes greater than a specified area
    public void removeAllGreaterThan(double area) {
        root = removeAllGreaterThanRecursive(root, area);
    }

    // recursive method to remove all shapes greater than a specified area
    private ShapeNode removeAllGreaterThanRecursive(ShapeNode node, double area) {
        if (node == null) {
            return null;
        }
        if (node.area > area) {
            node.left = removeAllGreaterThanRecursive(node.left, area);
            node.right = removeAllGreaterThanRecursive(node.right, area);
            return removeRecursive(node, node.type, node.area, 0);
        }
        return node;
    }

    // in-order traversal
    public void inorder() {
        inorderRecursive(root);
    }

    // recursive method for in-order traversal
    private void inorderRecursive(ShapeNode node) {
        if (node != null) {
            inorderRecursive(node.left);
            System.out.println("Type: " + node.type + ", Area: " + node.area);
            inorderRecursive(node.right);
        }
    }

    // to read shapes from a file and add them to the BST
    public void readFromFile(String filename) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(filename));
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] parts = line.split("\t");
            if (parts.length < 2) {
                System.out.println("Invalid line: " + line);
                continue; // skip this line and proceed to the next one
            }
            String type = parts[0];
            double dimension1 = Double.parseDouble(parts[1]);
            double dimension2 = 0.0;
            if (parts.length > 2) {
                dimension2 = Double.parseDouble(parts[2]);
            }
            double area = 0.0;
            if (type.equals("Rectangle")) {
                area = dimension1 * dimension2;
            } else if (type.equals("Circle")) {
                area = Math.PI * dimension1 * dimension1;
            } else if (type.equals("Right Triangle")) {
                area = 0.5 * dimension1 * dimension2;
            }
            insert(type, area);
        }
        scanner.close();
    }

    // write shapes to a file
    public void writeToFile(PrintWriter writer) {
        writeRecursive(root, writer);
    }

    // recursive method to write shapes to a file
    private void writeRecursive(ShapeNode node, PrintWriter writer) {
        if (node != null) {
            writeRecursive(node.left, writer);
            writer.println(node.type + "\t" + node.area);
            writeRecursive(node.right, writer);
        }
    }

 // pre-order traversal
    public void preorder() {
        preorderRecursive(root);
    }

    // recursive method for pre-order traversal
    private void preorderRecursive(ShapeNode node) {
        if (node != null) {
            System.out.println("Type: " + node.type + ", Area: " + node.area);
            preorderRecursive(node.left);
            preorderRecursive(node.right);
        }
    }

    // perform post-order traversal
    public void postorder() {
        postorderRecursive(root);
    }

    // recursive method for post-order traversal
    private void postorderRecursive(ShapeNode node) {
        if (node != null) {
            postorderRecursive(node.left);
            postorderRecursive(node.right);
            System.out.println("Type: " + node.type + ", Area: " + node.area);
        }
    }
}

// main class to run the program
public class ShapeTree {
    // Main method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ShapeBST shapeBST = new ShapeBST();

        System.out.println("Welcome to the Shape Tree!");

        int choice;
        do {
            System.out.println("\nEnter 1. To Read a Shape Tree from a File.");
            System.out.println("Enter 2. To Print a Tree Traversal to the Console");
            System.out.println("Enter 3. To Add a Shape.");
            System.out.println("Enter 4. To Remove a Shape.");
            System.out.println("Enter 5. To Search for a Shape.");
            System.out.println("Enter 6. To Find the Shape with the Max Area.");
            System.out.println("Enter 7. To Remove All Shapes Greater than an Area.");
            System.out.println("Enter 8. To Print Shape Tree to File.");
            System.out.println("Enter 0. To Quit.");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter the file's name:");
                    scanner.nextLine(); 
                    String filename = scanner.nextLine();
                    try {
                        shapeBST.readFromFile(filename);
                        System.out.println("Printing after Reading In-Order:");
                        shapeBST.inorder();
                    } catch (FileNotFoundException e) {
                        System.out.println("File not found.");
                    }
                    break;
                case 2:
                    System.out.println("Which traversal?");
                    System.out.println("Enter 1. For Pre-order.");
                    System.out.println("Enter 2. For In-order");
                    System.out.println("Enter 3. For Post-order");
                    int traversalChoice = scanner.nextInt();
                    switch (traversalChoice) {
                        case 1:
                            System.out.println("Pre-order Traversal:");
                            shapeBST.preorder();
                            break;
                        case 2:
                            System.out.println("In-order Traversal:");
                            shapeBST.inorder();
                            break;
                        case 3:
                            System.out.println("Post-order Traversal:");
                            shapeBST.postorder();
                            break;
                        default:
                            System.out.println("Invalid choice.");
                    }
                    break;
                case 3:
                    System.out.println("Enter the type of shape to add (Rectangle, Circle, Right Triangle):");
                    scanner.nextLine(); // Consume newline
                    String type = scanner.nextLine().trim();
                    double dimension1, dimension2;
                    switch (type.toLowerCase()) {
                        case "rectangle":
                            System.out.println("Enter the length followed by the width:");
                            dimension1 = scanner.nextDouble();
                            dimension2 = scanner.nextDouble();
                            shapeBST.insert(type, dimension1 * dimension2);
                            break;
                        case "circle":
                            System.out.println("Enter the radius:");
                            dimension1 = scanner.nextDouble();
                            shapeBST.insert(type, Math.PI * dimension1 * dimension1);
                            break;
                        case "right triangle":
                            System.out.println("Enter the base followed by the height:");
                            dimension1 = scanner.nextDouble();
                            dimension2 = scanner.nextDouble();
                            shapeBST.insert(type, 0.5 * dimension1 * dimension2);
                            break;
                        default:
                            System.out.println("Invalid shape type.");
                            continue;
                    }
                    break;
                case 4:
                    System.out.println("Enter the type of shape to remove (Rectangle, Circle, Right Triangle):");
                    scanner.nextLine(); 
                    type = scanner.nextLine().trim();
                    System.out.println("Enter the dimensions of the shape:");
                    dimension1 = scanner.nextDouble();
                    dimension2 = 0.0;
                    if (type.equals("Rectangle") || type.equals("Right Triangle")) {
                        dimension2 = scanner.nextDouble();
                    }
                    shapeBST.remove(type, dimension1, dimension2);
                    break;
                case 5:
                    System.out.println("Enter the type of shape to search (Rectangle, Circle, Right Triangle):");
                    scanner.nextLine(); 
                    type = scanner.nextLine().trim();
                    System.out.println("Enter the dimensions of the shape:");
                    dimension1 = scanner.nextDouble();
                    dimension2 = 0.0;
                    if (type.equals("Rectangle") || type.equals("Right Triangle")) {
                        dimension2 = scanner.nextDouble();
                    }
                    boolean found = shapeBST.search(type, dimension1, dimension2);
                    if (found) {
                        System.out.println("Shape found in the tree.");
                    } else {
                        System.out.println("Shape not found in the tree.");
                    }
                    break;
                case 6:
                    ShapeNode maxShape = shapeBST.findMax();
                    if (maxShape != null) {
                        System.out.println("Shape with max area: Type: " + maxShape.type + ", Area: " + maxShape.area);
                    } else {
                        System.out.println("Shape tree is empty.");
                    }
                    break;
                case 7:
                    System.out.println("Enter the maximum area:");
                    double maxArea = scanner.nextDouble();
                    shapeBST.removeAllGreaterThan(maxArea);
                    break;
                case 8:
                    System.out.println("Enter the file name to print the tree:");
                    scanner.nextLine(); 
                    String fileName = scanner.nextLine();
                    try {
                        PrintWriter writer = new PrintWriter(new File(fileName));
                        shapeBST.writeToFile(writer);
                        writer.close();
                        System.out.println("Shape tree printed to file successfully.");
                    } catch (FileNotFoundException e) {
                        System.out.println("File not found.");
                    }
                    break;
                case 0:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);

        scanner.close();
    }
}
