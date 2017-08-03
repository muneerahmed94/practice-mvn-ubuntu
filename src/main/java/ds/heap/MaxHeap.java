package ds.heap;

import org.apache.commons.lang.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxHeap implements Heap {

    public List<Integer> list;

    public MaxHeap() {
        list = new ArrayList<Integer>();
    }

    public MaxHeap(int[] ar) {
        list = new ArrayList<Integer>();
        buildHeap(ar);
    }

    public int getSize() {
        return list.size();
    }

    public void buildHeap(int[] ar) {
        list.addAll(Arrays.asList(ArrayUtils.toObject(ar)));
        for(int i = ar.length / 2; i >= 0; i--) {
            moveDown(i);
        }
    }

    public void moveUp(int i) {

    }

    public void moveDown(int i) {
        int max = i;
        int left = 2*i + 1;
        int right = 2*i + 2;

        if(left < list.size() && list.get(left) > list.get(max)) {
            max = left;
        }

        if(right < list.size() && list.get(right) > list.get(max)) {
            max = right;
        }

        if(max != i) {
            int temp = list.get(i);
            list.set(i, list.get(max));
            list.set(max, temp);

            moveDown(max);
        }

    }

    public Integer extractMax() {
        Integer max = list.get(0);
        int listSize = list.size();
        list.set(0, list.get(listSize - 1));
        list.remove(listSize - 1);
        moveDown(0);
        return max;
    }

    public void printHeap() {
        for(int x: list) {
            System.out.println(x);
        }
    }
}
