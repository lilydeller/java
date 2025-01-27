
/*
 * LILY DELLER
 */

import java.util.ArrayList;
import java.util.Collections;

class MinHeap<T extends Comparable<T>> {
    private ArrayList<T> heap;

    // constructor
    public MinHeap() {
        heap = new ArrayList<>();
    }

    // method to check if heap is empty
    public boolean isEmpty() {
        return heap.isEmpty();
    }

    // method to add element to the heap
    public void add(T element) {
        heap.add(element);
        int currentIndex = heap.size() - 1;
        while (currentIndex > 0) {
            int parentIndex = (currentIndex - 1) / 2;
            if (heap.get(currentIndex).compareTo(heap.get(parentIndex)) < 0) {
                Collections.swap(heap, currentIndex, parentIndex);
                currentIndex = parentIndex;
            } else {
                break;
            }
        }
    }

    // method to remove and return the first element in the heap
    public T remove() {
        if (heap.isEmpty()) {
            return null;
        }
        T removed = heap.get(0);
        heap.set(0, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);

        int currentIndex = 0;
        while (currentIndex < heap.size()) {
            int leftChildIndex = 2 * currentIndex + 1;
            int rightChildIndex = 2 * currentIndex + 2;
            int smallestIndex = currentIndex;
            if (leftChildIndex < heap.size() && heap.get(leftChildIndex).compareTo(heap.get(smallestIndex)) < 0) {
                smallestIndex = leftChildIndex;
            }
            if (rightChildIndex < heap.size() && heap.get(rightChildIndex).compareTo(heap.get(smallestIndex)) < 0) {
                smallestIndex = rightChildIndex;
            }
            if (smallestIndex != currentIndex) {
                Collections.swap(heap, currentIndex, smallestIndex);
                currentIndex = smallestIndex;
            } else {
                break;
            }
        }
        return removed;
    }
}
