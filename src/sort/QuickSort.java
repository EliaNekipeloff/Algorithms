package sort;

/**
 * This interface provides the implementation of quick sort algorithm.
 * Quicksort, or partition-exchange sort, is a sorting algorithm developed by Tony Hoare that, on average, makes O(n log n) comparisons to sort n items. In the worst case, it makes O(n2) comparisons, though this behavior is rare. Quicksort is often faster in practice than other O(n log n) algorithms.[1] Additionally, quicksort's sequential and localized memory references work well with a cache. Quicksort is a comparison sort and, in efficient implementations, is not a stable sort. Quicksort can be implemented with an in-place partitioning algorithm, so the entire sort can be done with only O(log n) additional space used by the stack during the recursion.
 */
public interface QuickSort {

    public static void sort(Comparable[] arr) {
        sortIteration(arr, 0, arr.length - 1);
    }

    @SuppressWarnings("unchecked")
    public static void sortIteration(Comparable[] arr, int low, int high) {
       int i = low;
        int j = high;
        Comparable pivot = getMin(new Comparable[] {arr[low], arr[(low + high)/2], arr[high]});
        do {
            while (arr[i].compareTo(pivot) < 0) i++;
            while (arr[j].compareTo(pivot) > 0) j--;
            if (i <= j) {
                Comparable temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }   while (i < j);
        if (j < low) sortIteration(arr, j, low);
        if (i < high) sortIteration(arr, i, high);
    }

    @SuppressWarnings("unchecked")
    public static Comparable getMin(Comparable[] values) {
        Comparable min = values[0];
        for (int i = 1; i < values.length; i++) {
            if (values[i].compareTo( min) < 0) {
                min = values[i];
            }
        }
        return min;
    }
}
