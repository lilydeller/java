//LILY DELLER 
import java.io.File;
import java.util.Scanner;

//class to represent a grocery item 
class GroceryItem {
	//private to store the name and value of items
    private String name;
    private double value;

    //default construction initializes name to none and value to 0 
    public GroceryItem() {
        this.name = "none";
        this.value = 0;
    }
    
    //parameterized constructor to set name/value to the grocery item
    public GroceryItem(String name, double value) {
        this.name = (name != null) ? name : "none";
        this.value = value;
    }

    //getter method to retrieve name of grocery item
    public String getName() {
        return name;
    }

    //setter method to make the name of grocery item 
    public void setName(String name) {
    	//make sure the name is not null 
        if (name != null) {
            this.name = name;
        }
    }

    //getter method to retrieve the value of grocery item 
    public double getValue() {
        return value;
    }

    //setter method to set the value of the item 
    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Grocery Item Name: " + name + " Value: " + value;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof GroceryItem) {
            GroceryItem other = (GroceryItem) obj;
            return this.name.equals(other.name) && this.value == other.value;
        }
        return false;
    }
}
