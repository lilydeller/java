public class Main {
    public static void main(String[] args) {
        // Creating shapes and rectangles
        Shape shape1 = new Shape();
        Shape shape2 = new Shape("Circle");
        Shape shape3 = new Shape("Circle");
        Shape shape4 = new Shape("Triangle");
        

        Rectangle rectangle1 = new Rectangle();
        Rectangle rectangle2 = new Rectangle("Rectangle", 2.0, 3.0);
        Rectangle rectangle3 = new Rectangle("Square", 2.5, 2.5);
        Rectangle rectangle4 = new Rectangle("Square", 2.5, 2.5);

        // Printing area, toString, and equals for shapes
        printDetails(shape1);
        printDetails(shape2);
        printDetails(shape3);
        printDetails(shape4);

        // Printing area, toString, and equals for rectangles
        printDetails(rectangle1);
        printDetails(rectangle2);
        printDetails(rectangle3);
        printDetails(rectangle4);
        
        //checking if its identical to other shapes
        System.out.println("shape 1 equals shape 2: " + shape1.equals(shape2));
        System.out.println("shape 1 equals shape 3: " + shape1.equals(shape3));
        System.out.println("shape 1 equals shape 4: " + shape1.equals(shape4));
        System.out.println("shape 2 equals shape 3: " + shape2.equals(shape3));
        System.out.println("shape 2 equals shape 4: " + shape2.equals(shape4));
        System.out.println("shape 3 equals shape 4: " + shape3.equals(shape4));
        
        //checking if rectangles are identical 
        System.out.println("rectangle 1 equals rectangle 2: " + rectangle1.equals(rectangle2));
        System.out.println("rectangle 1 equals rectangle 3: " + rectangle1.equals(rectangle3));
        System.out.println("rectangle 1 equals rectangle 4: " + rectangle1.equals(rectangle4));
        System.out.println("rectangle 2 equals rectangle 3: " + rectangle2.equals(rectangle3));
        System.out.println("rectangle 2 equals rectangle 4: " + rectangle2.equals(rectangle4));
        System.out.println("rectangle 3 equals rectangle 4: " + rectangle3.equals(rectangle4));
    }

    private static void printDetails(Object obj) {
        System.out.println("Object: " + obj);
        System.out.println("Area: " + ((obj instanceof Rectangle) ? ((Rectangle) obj).area() : ((Shape) obj).area()));
        System.out.println("ToString: " + obj.toString());
        System.out.println("Equals with identical: " + obj.equals(obj));
        System.out.println("Equals with different: " + obj.equals(new Object()));
        System.out.println("--------------------------");
    }
}