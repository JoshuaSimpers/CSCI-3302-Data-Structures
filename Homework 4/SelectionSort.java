public class SelectionSort {
    public void sort(int[] array) {
        int n = array.length;
        int largeIndex;
        for (int last = n; last > 0; last--) {
            largeIndex = 0;
            for (int index = 1; index < last; index++) {
                if (array[index] > array[largeIndex]) {
                    largeIndex = index;
                }
            }
            Swap.swap(array, largeIndex, last - 1);
        }
    }
}
