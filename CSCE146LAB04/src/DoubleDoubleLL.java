
//LILY DELLER

class Node {
    double data; // FOR EACH ITEM IN THE LIST 
    Node next; // FOR THE NEXT ITEM ON THE LIST
    Node prev; // FOR THE PREVIOUS ITEM ON LIST

    
    public Node(double data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}


public class DoubleDoubleLL {
    private Node head; // FIRST ITEM
    private Node current; // THE ITEM WE'RE CURRENTLY LOOKING AT

    // MOVES DOWN LIST
    public void gotoNext() {
        if (current != null)
            current = current.next;
    }

    // METHOD TO GO TO PREVIOUS
    public void gotoPrev() {
        if (current != null)
            current = current.prev;
    }

    // 
    public void reset() {
        current = head;
    }

    // METHOD TO GO TO END
    public void gotoEnd() {
        current = head;
        while (current != null && current.next != null) {
            current = current.next;
        }
    }

    // DOES IT HAVE MORE?
    public boolean hasMore() {
        return current != null;
    }

    // WHAT IS THE CURRENT NUMBER WE'RE LOOKING AT?
    public Double getCurrent() {
        return current != null ? current.data : null;
    }

    // CHANGES TO WHAT WE'RE CURRENTLY LOOKING AT 
    public void setCurrent(double newData) {
        if (current != null)
            current.data = newData;
    }

    // ADD NEW TO LIST
    public void add(double data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            current = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.prev = temp;
        }
    }

    // 
    public void addAfterCurrent(double data) {
        if (current != null) {
            Node newNode = new Node(data);
            newNode.next = current.next;
            if (current.next != null)
                current.next.prev = newNode;
            current.next = newNode;
            newNode.prev = current;
        }
    }

    // REMOVES FROM LIST
    public void remove(double data) {
        if (head == null) return;

        if (head.data == data) {
            head = head.next;
            if (head != null)
                head.prev = null;
            current = head;
            return;
        }

        Node temp = head;
        while (temp != null && temp.data != data) {
            temp = temp.next;
        }
        if (temp == null) return;

        if (temp.next != null)
            temp.next.prev = temp.prev;
        temp.prev.next = temp.next;
        if (temp == current) {
            current = temp.next; 
        }
    }

    // REMOVES WHAT WE'RE CURRENTLY ON 
    public void removeCurrent() {
        if (current == null) return;

        if (current == head) {
            head = head.next;
            if (head != null)
                head.prev = null;
            current = head; // IF THE ONE WE'RE LOOKING AT IS THE HEAD
            return;
        }

        if (current.next != null) {
            current.next.prev = current.prev;
        }
        current.prev.next = current.next;

        
        if (current.next == null) {
            current = findLast();
        } else {
            current = current.next;
        }
    }

    // FINDING THE LIST ITEM ON LIST
    private Node findLast() {
        Node temp = head;
        while (temp != null && temp.next != null) {
            temp = temp.next;
        }
        return temp;
    }

    // METHOD TO PRINT EVERYTHING
    public void print() {

        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    // ONLY TO PRINT LAST ELEMENT
    public void printLastElement() {

        if (head == null) {
            System.out.println("The list is empty.");
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            System.out.println("Print last element: " + temp.data);
        }
    }

    // DOES IT EXIST? CHECKS
    public boolean contains(double data) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == data)
                return true;
            temp = temp.next;
        }
        return false;
    }
}
