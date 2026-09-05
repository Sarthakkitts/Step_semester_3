import java.util.Arrays;

public class ProductExceptSelf {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4};
        System.out.println(Arrays.toString(productExceptSelf(numbers)));
    }

    static int[] productExceptSelf(int[] nums) {
        int[] answer = new int[nums.length];
        int prefixProduct = 1;

        for (int i = 0; i < nums.length; i++) {
            answer[i] = prefixProduct;
            prefixProduct *= nums[i];
        }

        int suffixProduct = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            answer[i] *= suffixProduct;
            suffixProduct *= nums[i];
        }
        return answer;
    }
}
