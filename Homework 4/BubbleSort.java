public class BubbleSort {
    public void sort(int[] array) {
        int N = array.length - 1;
        for (int pass = 0; pass < N; pass++) {
            for (int index = 0; index < N - pass; index++) {
                if (array[index] > array[index+1]) {
                    Swap.swap(array, index, index+1);
                }
            }
        }
    }
}
