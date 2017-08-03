package ds.heap;

public interface Heap {
    void buildHeap(int[] ar);
    void moveUp(int i);
    void moveDown(int i);
    void printHeap();
}
