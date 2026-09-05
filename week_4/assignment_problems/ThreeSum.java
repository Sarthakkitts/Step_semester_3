import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        int[] numbers = {-1, 0, 1, 2, -1, -4};
        int[][] triplets = threeSum(numbers);

        for (int[] triplet : triplets) {
            System.out.println(Arrays.toString(triplet));
        }
    }

    static int[][] threeSum(int[] nums) {
        int[] sortedNumbers = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sortedNumbers);
        List<int[]> triplets = new ArrayList<>();

        for (int i = 0; i < sortedNumbers.length - 2; i++) {
            if (i > 0 && sortedNumbers[i] == sortedNumbers[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = sortedNumbers.length - 1;

            while (left < right) {
                int sum = sortedNumbers[i] + sortedNumbers[left] + sortedNumbers[right];

                if (sum == 0) {
                    triplets.add(new int[]{sortedNumbers[i], sortedNumbers[left], sortedNumbers[right]});
                    left++;
                    right--;

                    while (left < right && sortedNumbers[left] == sortedNumbers[left - 1]) {
                        left++;
                    }
                    while (left < right && sortedNumbers[right] == sortedNumbers[right + 1]) {
                        right--;
                    }
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return triplets.toArray(new int[triplets.size()][]);
    }
}
