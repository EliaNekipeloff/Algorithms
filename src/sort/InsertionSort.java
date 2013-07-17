package sort;

/**
** This is the interface which implements of the sorting algorithm called Straight Insertion.
 * A sorting algorithm that looks at each sortkey in turn, and on the basis of this places the record corresponding to the sortkey correctly with respect to the previous sortkeys.
 * The best case input is an array that is already sorted. In this case insertion sort has a linear running time (i.e., Θ(n)). During each iteration, the first remaining element of the input is only compared with the right-most element of the sorted subsection of the array.
 * The simplest worst case input is an array sorted in reverse order. The set of all worst case inputs consists of all arrays where each element is the smallest or second-smallest of the elements before it. In these cases every iteration of the inner loop will scan and shift the entire sorted subsection of the array before inserting the next element. This gives insertion sort a quadratic running time (i.e., O(n2)).
 * The average case is also quadratic, which makes insertion sort impractical for sorting large arrays. However, insertion sort is one of the fastest algorithms for sorting very small arrays, even faster than quicksort; indeed, good quicksort implementations use insertion sort for arrays smaller than a certain threshold, also when arising as subproblems; the exact threshold must be determined experimentally and depends on the machine, but is commonly around ten.
 */
public interface InsertionSort {

    @SuppressWarnings("unchecked")
    public static void sort(Comparable arr[]) {
        for (int i = 0; i < arr.length; i++) {
            int j = i-1;
            Comparable temp = arr[i];
            while (j >= 0 && temp.compareTo(arr[j]) < 0) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = temp;
        }
    }
}
