//LILY DELLER
//class to represent grocery list
public class GroceryList {
	//private inner class to represent each node in our list 
    private class ListNode {
        private GroceryItem data; //data in the node
        private ListNode link; //reference the next 

        //constructor to initialize the note with data 
        public ListNode(GroceryItem data, ListNode link) {
            this.data = data;
            this.link = link;
        }
    }

    private ListNode head; //head reference to the first node
    private ListNode current; // reference to our current node
    private ListNode previous; //reference to our previous node 
 
    //constructor to initialize the grocery list with an empty head 
    public GroceryList() {
        head = new ListNode(null, null);
        current = head;
        previous = null;
    }
     
    //METHOD TO MOVE TO THE NEXT NODE ON THE LIST 
    public void gotoNext() {
        if (current != null && current.link != null) {
            previous = current;
            current = current.link;
        }
    }

    //method to get the data of the current 
    public GroceryItem getCurrent() {
        if (current != null) {
            return current.data;
        }
        return null;
    }

    public void setCurrent(GroceryItem data) {
        if (current != null && data != null) {
            current.data = data;
        }
    }

    //method to add a new grocery item to the end of the list
    public void addItem(GroceryItem groceryItem) {
        if (groceryItem != null) {
            ListNode newNode = new ListNode(groceryItem, null);
            if (head.data == null) {
                head = newNode;
                current = head;
            } else {
                ListNode temp = head;
                while (temp.link != null) {
                    temp = temp.link;
                }
                temp.link = newNode;
            }
        }
    }

    //method to add a new item after the current 
    public void addItemAfterCurrent(GroceryItem groceryItem) {
        if (current != null && groceryItem != null) {
            ListNode newNode = new ListNode(groceryItem, current.link);
            current.link = newNode;
        }
    }

    //method to remove the current node from the list 
    public void removeCurrent() {
        if (current != null) {
            if (previous != null) {
                previous.link = current.link;
            } else {
                head = current.link;
            }
            current = current.link;
        }
    }

    //method to display the entire list 
    public void showList() {
        ListNode temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.link;
        }
    }

    //method to check if the list contains specific item 
    public boolean contains(GroceryItem data) {
        ListNode temp = head;
        while (temp != null) {
            if (temp.data.equals(data)) {
                return true;
            }
            temp = temp.link;
        }
        return false;
    }

    //method to calculate the total cost of the entire list 
    public double totalCost() {
        double total = 0;
        ListNode temp = head;
        while (temp != null) {
            total += temp.data.getValue();
            temp = temp.link;
        }
        return total;
    }

    //method to test functionality of the class 
    public static void main(String[] args) {
        GroceryListTester tester = new GroceryListTester();
        tester.test01();
        tester.test02();
        tester.test03();
        tester.test04();
    }
}