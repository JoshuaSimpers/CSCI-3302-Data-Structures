public class QuickSort {
    public void sort(int[] array, int first, int last) {
        int pivotIndex;
        if (first < last) {
            pivotIndex = partition(array, first, last);
            sort(array, first, pivotIndex);
            //sort(array, pivotIndex + 1, last);
        }
    }

    private int partition(int[] array, int first, int last) {
        int pivotIndex = (int) ((Math.random() * (last - first + 1)) + first);
        int pivot = array[pivotIndex];
        Swap.swap(array, pivotIndex, last - 1);
        pivotIndex = first;
        for (int i = first; i < last - 1; i++) {
            if (array[i] <= pivot) {
                Swap.swap(array, i, pivotIndex);
            }
            pivotIndex++;
        }
        Swap.swap(array, pivotIndex, last - 1);
        return pivotIndex;
    }
}
