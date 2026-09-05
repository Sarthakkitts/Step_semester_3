import java.util.Arrays;

public class MergeTwoSortedArrays {
    public static void main(String[] args) {
        int[] first = {1, 3, 5};
        int[] second = {2, 4, 6};
        System.out.println(Arrays.toString(mergeSortedArrays(first, second)));
    }

    static int[] mergeSortedArrays(int[] arr1, int[] arr2) {
        int[] merged = new int[arr1.length + arr2.length];
        int firstIndex = 0;
        int secondIndex = 0;
        int mergedIndex = 0;

        while (firstIndex < arr1.length && secondIndex < arr2.length) {
            if (arr1[firstIndex] <= arr2[secondIndex]) {
                merged[mergedIndex++] = arr1[firstIndex++];
            } else {
                merged[mergedIndex++] = arr2[secondIndex++];
            }
        }

        while (firstIndex < arr1.length) {
            merged[mergedIndex++] = arr1[firstIndex++];
        }

        while (secondIndex < arr2.length) {
            merged[mergedIndex++] = arr2[secondIndex++];
        }
        return merged;
    }
}
