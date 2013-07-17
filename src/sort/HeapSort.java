package sort;

/**
 Heapsort is a comparison-based sorting algorithm to create a sorted array (or list), and is part of the selection sort family. Although somewhat slower in practice on most machines than a well-implemented quicksort, it has the advantage of a more favorable worst-case O(n log n) runtime. Heapsort is an in-place algorithm, but it is not a stable sort.
 */
public interface HeapSort {
    public static void sort(Comparable[] arr) {
        for (int i = arr.length/2; i >=0; i--) {
            percDown(arr, i, arr.length);
        }
        for (int i = arr.length-1; i >0; i--) {
            Comparable temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            percDown(arr, 0, i);
        }
    }

    @SuppressWarnings("unchecked")
    public static void percDown(Comparable[] arr, int i, int size) {
        int childIndex;
        Comparable temp;

        for (temp = arr[i]; getLeftChildIndex(i) < size; i = childIndex) {
            childIndex = getLeftChildIndex(i);
            if (childIndex != size-1 && arr[childIndex].compareTo(arr[i]) < 0) {
                childIndex++;
            }
            if (temp.compareTo(arr[childIndex]) < 0) {
                arr[i] = arr[childIndex];
            } else {
                break;
            }
        }
        arr[i] = temp;
    }

    public static int getLeftChildIndex(int i) {
        return 2*i +1;
    }

}
