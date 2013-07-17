package sort;

import java.util.HashMap;
import java.util.Map;

/**
 This class demonstrate sorting via Straight Insertion
 */
public class SortingDemo {

    private Integer arr[];
    private static final Map<String, Integer> SORT_TYPES = new HashMap<>();
    static {
        SORT_TYPES.put("insertion", 0);
        SORT_TYPES.put("selection", 1);
        SORT_TYPES.put("bubble", 2);
        SORT_TYPES.put("quick", 3);
        SORT_TYPES.put("heap", 4);
        SORT_TYPES.put("merge", 5);
    }
    private String sortName;

    public SortingDemo(String[] args) {
        arr =  new Integer[args.length - 1];
        sortName = args[0];
        for (int i= 1; i<args.length; i++) {
            arr[i-1] = Integer.decode(args[i]);
        }
    }

    public static void main(String[] args) throws Exception {
        assert (args.length > 0);
        SortingDemo demo = new SortingDemo(args);
        demo.sort();
        demo.print();
    }


    private void sort() throws Exception{
        int sortNum = SORT_TYPES.get(sortName) == null ? -1 : SORT_TYPES.get(sortName);
        assert sortNum >= 0;
        assert  arr.length > 0;
        switch (sortNum) {
            case 0:
                InsertionSort.sort(arr);
                break;
            case 1:
                SelectionSort.sort(arr);
                break;
            case 2:
                BubbleSort.sort(arr);
                break;
            case 3:
                QuickSort.sort(arr);
                break;
            case 4:
                HeapSort.sort(arr);
                break;
            case 5:
                MergeSort.sort(arr);
                break;
            default:
                throw new Exception("Wrong sorting name.");
        }
    }

    private void print() {
        for (int anArr : arr) {
            System.out.println(anArr);
        }
    }

}
