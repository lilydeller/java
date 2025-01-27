//LILY DELLER
class LLQueue<T> implements QueueI<T> {
    private Node<T> head;
    private Node<T> tail;

    // our node class for Queue
    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    // enqueue method - adds an item from the back of the queue
    public void enqueue(T data) {
        Node<T> newNode = new Node<>(data);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    // dequeue method
    public T dequeue() {
        if (head == null) {
            return null;
        }
        T data = head.data;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        return data;
    }

    // peek method
    public T peek() {
        if (head == null) {
            return null;
        }
        return head.data;
    }

    // print  method
    public void print() {
        Node<T> current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }
}