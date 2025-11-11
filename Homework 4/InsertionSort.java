public class InsertionSort {
    public void sort(int[] array) {
        int unsorted;
        int N = array.length;
        int loc;
        int nextItem;
        for (unsorted = 1; unsorted < N; unsorted++) {
            nextItem = array[unsorted];
            loc = unsorted;
            while(loc > 0 && array[loc - 1] > nextItem) {
                array[loc] = array[loc - 1];
                loc = loc - 1;
            }
            array[loc] = nextItem;
        }
    }
}
