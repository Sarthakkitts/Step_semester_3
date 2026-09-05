import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {
    public static void main(String[] args) {
        int[] numbers = {1, 1, 1};
        System.out.println("Subarrays with sum 2: " + subarraySum(numbers, 2));
    }

    static int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixFrequencies = new HashMap<>();
        prefixFrequencies.put(0, 1);
        int runningSum = 0;
        int count = 0;

        for (int number : nums) {
            runningSum += number;
            count += prefixFrequencies.getOrDefault(runningSum - k, 0);
            prefixFrequencies.put(runningSum, prefixFrequencies.getOrDefault(runningSum, 0) + 1);
        }
        return count;
    }
}
