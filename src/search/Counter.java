package search;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
* This class provides the functionality of different math operations on a large array of numbers
 * @author  EliaNekipeloff
 */
public class Counter {
    private String path;
    private int[] array;
    private final  int size;

    /**
     * Main parameterized constructor
     * @param path - a path to file with an array
     * @param size - the array's size
     */
    public Counter(final String path, final int size) {
        this.path = path;
        this.size = size;
        array = readData();
    }

    /**
     * Counts the quantity of the array's elements which sum equals  the appropriate sum
     * @param sum to compare
     * @return the quantity of the elements
     */
    public long getSumElementsCount(long sum) {
        long count = 0;
        sort();
        int length = (int)sum;
        int center = length/2;

        long startTime = System.currentTimeMillis();
        for (int i = 0; i <= center; i++) {
            for (int j = center-1; j < length; j++) {
                if (array[i] + array[j] == sum) {
                    count++;
                    break;
                }
            }
        }
        System.out.println("Elapsed time = " + (System.currentTimeMillis() - startTime));
        return count;
    }

    public void sort()  {
        sortIteration(array, 0, array.length -1);
    }
    private void sortIteration(int[] array, int low, int high) {
        if (high > low) {
            int middle = (low + high)/2;
            sortIteration(array, low, middle);
            sortIteration(array, middle+1, high);
            merge(array, low, middle, high);
        }
    }


    @SuppressWarnings("unchecked")
    private void merge(int[] arr, int low, int middle, int high) {
        int i = low, j = middle + 1, k = 0;
        int num = high - low + 1;
        int[] temp = new int[num];
        while (  i <= middle && j <= high) {
            if (arr[i] <arr[j]) {
                temp[k++] = arr[i++];
            }
            if (arr[j] < arr[i])
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


    /**
     * Reads data from the file.
     * @return int[] array
     */
    private int[] readData() {
        BufferedReader br;
        int[] data;
        try {
            br = new BufferedReader(new FileReader(path));
            data = new int[size];
        } catch (FileNotFoundException e) {
            System.out.println("input file not found");
            return null;
        }

        try {
            int i = 0;
            while (br.ready()) {
                data[i] = new Integer(br.readLine());
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return data;
    }



    public static void main(String[] args) throws Exception{
            int argsLength = args.length;
            switch (argsLength) {
                case 0:
                    throw new Exception("You should type the path to the input file first.");
                case 1:
                    throw new Exception("You should type the sum first.");
                case 2:
                    throw new Exception("You should type the array's size first.");
                case 3:
                    String filePath = args[0];
                    int size = Integer.decode(args[1]);
                    long sum = Long.decode(args[2]);
                    if (size < sum) {
                        throw new Exception("Wrong data: array's size is less than the sum.");
                    }
                    Counter counter = new Counter(filePath, size);
                    System.out.println(counter.getSumElementsCount(sum));
                    break;
                default:
                    System.out.println("Wrong number of arguments");
                    break;
            }
    }
}
