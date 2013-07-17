package sort;

/**
 * This interface which implements the sorting algorithm called Merge Sort.
 * Merge sort (also commonly spelled mergesort) is an O(n log n) comparison-based sorting algorithm.
 * Most implementations produce a stable sort, which means that the implementation preserves the input order of equal elements in the sorted output.
 * Merge sort is a divide and conquer algorithm that was invented by John von Neumann in 1945.
 * A detailed description and analysis of bottom-up mergesort appeared in a report by Goldstine and Neumann as early as 1948.
 */
public interface MergeSort {

    public static void sort(Comparable[] array)  {
        sortIteration(array, 0, array.length -1);
    }
    public static void sortIteration(Comparable[] array, int low, int high) {
        if (high > low) {
            int middle = (low + high)/2;
            sortIteration(array, low, middle);
            sortIteration(array, middle+1, high);
            merge(array, low, middle, high);
        }
    }


    @SuppressWarnings("unchecked")
    public static void merge(Comparable[] arr, int low, int middle, int high) {
        int i = low, j = middle + 1, k = 0;
        int num = high - low + 1;
        Comparable[] temp = new Comparable[num];
        while (  i <= middle && j <= high) {
            if (arr[i].compareTo(arr[j]) < 0) {
                temp[k++] = arr[i++];
            }
            if (arr[j].compareTo(arr[i]) < 0 )
                temp[k++] = arr[j++];
        }
        while (i <= middle) {
            temp [k++] = arr[i++];

        }
        while( j <= high )  {
            temp [k++] = arr[j++];
        }

        int h = 0;
        for (i = low; i <= high; i++) {
            arr[i] = temp[h++];
        }
    }

}
