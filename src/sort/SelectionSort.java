package sort;

/**
 * This is the interface which implements of the sorting algorithm called Straight Selection.
 * A sorting algorithm based upon finding successively the record with the largest sortkey and putting it in the correct position, then the record with the next largest key, etc.
 * Selection sort is not difficult to analyze compared to other sorting algorithms since none of the loops depend on the data in the array. Selecting the lowest element requires scanning all n elements (this takes n − 1 comparisons) and then swapping it into the first position. Finding the next lowest element requires scanning the remaining n − 1 elements and so on, for (n − 1) + (n − 2) + ... + 2 + 1 = n(n − 1) / 2 ∈ Θ(n2) comparisons (see arithmetic progression). Each of these scans requires one swap for n − 1 elements (the final element is already in place).
 */
public interface SelectionSort {

    @SuppressWarnings("unchecked")
    public static void sort(Comparable[] arr) {
        for (int i = 0; i < arr.length -1; i++) {
            for (int j = i; j < arr.length; j++) {
                if (arr[i].compareTo(arr[j]) == 0) {
                    Comparable temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}
