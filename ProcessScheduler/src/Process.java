//LILY DELLER
import java.util.Random;

// need to define process class
class Process {
    private String name;
    private double completionTime;

    // our constructor
    Process(String name, double completionTime) {
        this.name = name;
        this.completionTime = completionTime;
    }

    // accessors and mutators
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCompletionTime() {
        return completionTime;
    }

    public void setCompletionTime(double completionTime) {
        this.completionTime = completionTime;
    }

    // toString method
    public String toString() {
        return "Process Name: " + name + " Completion Time: " + completionTime;
    }
}

// need to define Queue interface
interface QueueI<T> {
    void enqueue(T data);
    T dequeue();
    T peek();
    void print();
}

