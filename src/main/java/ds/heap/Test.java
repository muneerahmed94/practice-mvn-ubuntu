package ds.heap;

public class Test {
    public static void main(String[] args) {
        int[] ar = new int[] {35, 33, 42, 10, 14, 19, 27, 44, 26, 31};
        /*heapSort(ar);
        MaxHeap maxHeap = new MaxHeap(ar);

        while(maxHeap.list.size() > 0) {
            System.out.println(maxHeap.extractMax());
        }*/
        heapSort(ar);
        for(int x: ar) {
            System.out.print(x + " ");
        }

    }

    private static void heapSort(int[] ar) {
        for(int i = ar.length/2; i >= 0; i--) {
            moveDown(ar, i, ar.length);
        }

        for(int x: ar) {
            System.out.println(x);
        }

        for(int n = ar.length - 1; n >= 0; n--) {
            int t = ar[0];
            ar[0] = ar[n];
            ar[n] = t;

            moveDown(ar, 0, n);
        }
    }

    private static void moveDown(int[] ar, int i, int n) {
        int max = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if(left < n && ar[left] > ar[max]) {
            max = left;
        }

        if(right < n && ar[right] > ar[max]) {
            max = right;
        }

        if(i != max) {
            int t = ar[i];
            ar[i] = ar[max];
            ar[max] = t;

            moveDown(ar, max, n-1);
        }
    }


}
