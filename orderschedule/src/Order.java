/*
 * LILY DELLER
 */
import java.util.*;

// class representing an Order
class Order implements Comparable<Order> {
    private String customer;
    private String foodOrder;
    private int cookingTime;
    private int arrivalTime;
    private int cookingTimeLeft;

    // default Constructor
    public Order() {
        this.customer = "none";
        this.foodOrder = "none";
        this.cookingTime = 1;
        this.arrivalTime = 0;
        this.cookingTimeLeft = 1;
    }

    // parameterized Constructor
    public Order(String customer, String foodOrder, int cookingTime, int arrivalTime) {
        this();
        if (cookingTime > 0) {
            this.cookingTime = cookingTime;
            this.cookingTimeLeft = cookingTime;
        }
        if (arrivalTime >= 0) {
            this.arrivalTime = arrivalTime;
        }
        this.customer = customer;
        this.foodOrder = foodOrder;
    }

    // accessors
    public String getCustomer() {
        return customer;
    }

    public String getFoodOrder() {
        return foodOrder;
    }

    public int getCookingTimeLeft() {
        return cookingTimeLeft;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    // mutators
    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public void setFoodOrder(String foodOrder) {
        this.foodOrder = foodOrder;
    }

    public void setCookingTime(int cookingTime) {
        if (cookingTime > 0) {
            this.cookingTime = cookingTime;
        }
    }

    public void setArrivalTime(int arrivalTime) {
        if (arrivalTime >= 0) {
            this.arrivalTime = arrivalTime;
        }
    }

    // compareTo method implementation
    @Override
    public int compareTo(Order other) {
        return Integer.compare(this.cookingTime, other.cookingTime);
    }

    // method to simulate cooking for one minute
    public void cookForOneMinute() {
        if (cookingTimeLeft > 0) {
            cookingTimeLeft--;
        }
    }

    // method to check if order is done
    public boolean isDone() {
        return cookingTimeLeft == 0;
    }

    // toString method implementation
    @Override
    public String toString() {
        return "Customer: " + customer + ", Order: " + foodOrder + ", Cooking Time Left: " + cookingTimeLeft;
    }

	public int getArrivalTime1() {
		// TODO auto-generated method stub
		return 0;
	}
}

