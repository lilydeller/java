/*
 * LILY DELLER
 */
import java.util.ArrayList;

class MinHeap<T extends Comparable<T>> {
    private ArrayList<T> heap;
//constructor
    public MinHeap() {
        heap = new ArrayList<>();
    }
//adds element to the heap
    public void add(T item) {
        heap.add(item);
        int currentIndex = heap.size() - 1;
        int parentIndex = (currentIndex - 1) / 2;
        while (currentIndex > 0 && heap.get(currentIndex).compareTo(heap.get(parentIndex)) < 0) {
            swap(currentIndex, parentIndex);
            currentIndex = parentIndex;
            parentIndex = (currentIndex - 1) / 2;
        }
    }
//removes element to the heap
    public T remove() {
        if (heap.isEmpty()) return null;
        T removedItem = heap.get(0);
        heap.set(0, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);
        heapify(0);
        return removedItem;
    }
//helper method to swap elements in the heap
    private void heapify(int index) {
        int leftChildIndex = 2 * index + 1;
        int rightChildIndex = 2 * index + 2;
        int smallestIndex = index;

        if (leftChildIndex < heap.size() && heap.get(leftChildIndex).compareTo(heap.get(smallestIndex)) < 0) {
            smallestIndex = leftChildIndex;
        }
        if (rightChildIndex < heap.size() && heap.get(rightChildIndex).compareTo(heap.get(smallestIndex)) < 0) {
            smallestIndex = rightChildIndex;
        }

        if (smallestIndex != index) {
            swap(index, smallestIndex);
            heapify(smallestIndex);
        }
    }

    private void swap(int i, int j) {
        T temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }
    //is it empty??

    public boolean isEmpty() {
        return heap.isEmpty();
    }
}