//LILY DELLER
class Task {
    private String action; 
    private int priority; 

    // constructor to create a new task
    public Task(String action, int priority) {
        this.action = action;
        this.priority = priority;
    }

    // getters and setters to access and modify task details
    public String getAction() {
        return action; 
    }

    public void setAction(String action) {
        this.action = action; // update the task action
    }

    public int getPriority() {
        return priority; // get priority 
    }

    public void setPriority(int priority) {
        this.priority = priority; 
    }

    
    @Override
    public String toString() {
        return "Priority: " + priority + ", Action: " + action; 
    }
}

// GENERIC linked list node
class ListNode<T> {
    T data; // the data stored in the node
    ListNode<T> next; // to the next node

    // constructor to create a new node
    public ListNode(T data) {
        this.data = data; // Initialize 
        this.next = null; // Initialize 
    }
}

// GENERIC linked list implementation
class GenLL<T> {
    protected ListNode<T> head; // first node in the list
    protected int size; // number of nodes in the list

    // constructor to initialize an empty list
    public GenLL() {
        head = null; 
        size = 0; 
    }

    // method to add a new node to the end of the list
    public void add(T data) {
        ListNode<T> newNode = new ListNode<>(data); // create a new node with the given data
        if (head == null) {
            head = newNode; 
        } else {
            ListNode<T> current = head;
            while (current.next != null) {
                current = current.next; 
            }
            current.next = newNode; // add new node to end
        }
        size++; 
    }

    // method to remove a task from the list based on priority and action
    public void removeTask(GenLL<Task>[] organizedTasks, int priority, String action) {
        if (priority < 0 || priority >= organizedTasks.length) {
            System.out.println("Invalid priority."); // if priority is within valid range
            return;
        }

        GenLL<Task> tasks = organizedTasks[priority]; 
        ListNode<Task> current = tasks.head; 
        ListNode<Task> prev = null; 
        while (current != null) {
            if (current.data.getAction().equals(action)) { 
                if (prev == null) {
                    tasks.head = current.next; 
              
                    prev.next = current.next; 
                tasks.size--; 
                System.out.println("Task removed: " + current.data); 
                return;
            }
            prev = current; // move to the next node
            current = current.next;
        }
        System.out.println("Task not found."); 
    }
    }
}

