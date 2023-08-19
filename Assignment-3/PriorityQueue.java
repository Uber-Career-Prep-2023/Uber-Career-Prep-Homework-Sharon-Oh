import java.util.*;

public class PriorityQueue {
    private ArrayList<Integer> elements;
    private int size;

    public PriorityQueue() {
        arr = new Pair[10]; // Initial capacity of the array
        size = 0;
    }

    public String top() {
        if (size == 0) {
            return null;
        }
        return arr[0].element;
    }

    public void insert(String x, int weight) {
        if (size == arr.length) {
            resizeArray();
        }
        arr[size] = new Pair(x, weight);
        heapifyUp(size);
        size++;
    }

    public void remove() {
        if (size == 0) {
            return;
        }
        arr[0] = arr[size - 1];
        size--;
        heapifyDown(0);
    }

    private void heapifyUp(int index) {
        int parentIndex = (index - 1) / 2;

        while (index > 0 && arr[index].weight > arr[parentIndex].weight) {
            swap(index, parentIndex);
            index = parentIndex;
            parentIndex = (index - 1) / 2;
        }
    }

    private void heapifyDown(int index) {
        int leftChildIndex = (2 * index) + 1;
        int rightChildIndex = (2 * index) + 2;
        int largest = index;

        if (leftChildIndex < size && arr[leftChildIndex].weight > arr[largest].weight) {
            largest = leftChildIndex;
        }
        if (rightChildIndex < size && arr[rightChildIndex].weight > arr[largest].weight) {
            largest = rightChildIndex;
        }

        if (largest != index) {
            swap(index, largest);
            heapifyDown(largest);
        }
    }

    private void swap(int i, int j) {
        Pair temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private void resizeArray() {
        Pair[] newArr = Arrays.copyOf(arr, arr.length * 2);
        arr = newArr;
    }

    // created an inner class to make it easier because without it
    // i realized it would be a lot harder to be able to have both string & int
    // eszpecially in Java
    private class Pair {
        String element;
        int weight;

        Pair(String element, int weight) {
            this.element = element;
            this.weight = weight;
        }
    }

    public static void main(String[] args) {
        PriorityQueue pq = new PriorityQueue();
        pq.insert("Apple", 3);
        pq.insert("Banana", 1);
        pq.insert("Orange", 2);
        pq.insert("Grapes", 4);

        System.out.println(pq.top()); 

        pq.remove();

        System.out.println(pq.top()); 


        PriorityQueue pq2 = new PriorityQueue();
        System.out.println(pq2.top()); 
        pq2.remove();

        PriorityQueue pq3 = new PriorityQueue();
        pq3.insert("Red", 24);
        pq3.insert("Green", 9);
        pq3.insert("Blue", 0);
        System.out.println(pq3.);
    }
}
