import java.util.Arrays;

public class RotateArray {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7};
        System.out.println(Arrays.toString(rotateArray(numbers, 3)));
    }

    static int[] rotateArray(int[] nums, int k) {
        if (nums.length == 0) {
            return nums;
        }

        int[] rotated = new int[nums.length];
        k = k % nums.length;

        for (int i = 0; i < nums.length; i++) {
            rotated[(i + k) % nums.length] = nums[i];
        }
        return rotated;
    }
}
