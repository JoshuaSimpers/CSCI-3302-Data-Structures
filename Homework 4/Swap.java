public class Swap {
    public static void swap(int[] array, int firstItemIndex, int secondItemIndex) {
        int bucket = array[firstItemIndex];
        array[firstItemIndex] = array[secondItemIndex];
        array[secondItemIndex] = bucket;
    }
}
