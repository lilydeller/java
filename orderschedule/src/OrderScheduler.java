
/*
 * LILY DELLER
 */
class OrderScheduler {
    private MinHeap<Order> orders;
    private Order currentOrder;
    private int currentMinute;
    private int totalOrders;
    private int summedWaitingTimes;

    // constructor
    public OrderScheduler() {
        orders = new MinHeap<>();
        currentOrder = null;
        currentMinute = 0;
        totalOrders = 0;
        summedWaitingTimes = 0;
    }

    // method to add an order
    public void addOrder(Order order) {
        if (currentOrder == null) {
            currentOrder = order;
        } else {
            orders.add(order);
        }
        totalOrders++;
    }

 
 // method to advance one minute in simulation
    public void advanceOneMinute() {
        currentMinute++;
        if (currentOrder != null) {
            currentOrder.cookForOneMinute();
            if (currentOrder.isDone()) {
                summedWaitingTimes += (currentMinute - currentOrder.getArrivalTime());
                currentOrder = orders.remove();
            }
        }
    }


    // method to check if all orders are done
    public boolean isDone() {
        return currentOrder == null && orders.isEmpty();
    }

    // method to get the average waiting time
    public double getAverageWaitingTime() {
        if (totalOrders == 0) {
            return 0;
        }
        return (double) summedWaitingTimes / totalOrders;
    }

    // method to get the current order being cooked
    public Order getCurrentOrder() {
        return currentOrder;
    }
}

