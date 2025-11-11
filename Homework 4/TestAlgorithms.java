public class TestAlgorithms {
    public static void printArray(int[] array) {
        for (int number : array) {
            System.out.print(number + " ");
        }
        System.out.println();
    }

    public static int[] FillWithValues(int numOfvalues, int minRange, int maxRange) {
        int[] array = new int[numOfvalues];
        for (int i = 0; i < array.length; i++) {
            // sets the next value of the array equal to a random number within the user-specified range
            array[i] = (int) ((Math.random() * (maxRange - minRange + 1)) + minRange);
        }
        return array;
    }

    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();
        InsertionSort insertionSort = new InsertionSort();
        SelectionSort selectionSort = new SelectionSort();
        QuickSort quickSort = new QuickSort();
        int[] testArray = FillWithValues(10, 1, 100);
        printArray(testArray);
        bubbleSort.sort(testArray);
        printArray(testArray);
        testArray = FillWithValues(10, 1, 100);
        printArray(testArray);
        insertionSort.sort(testArray);
        printArray(testArray);
        testArray = FillWithValues(10, 1, 100);
        printArray(testArray);
        selectionSort.sort(testArray);
        printArray(testArray);
        testArray = FillWithValues(10, 1, 100);
        printArray(testArray);
        quickSort.sort(testArray, 0, 10);
        printArray(testArray);
    }
}
