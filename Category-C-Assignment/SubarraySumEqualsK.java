import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {
    static int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixCounts = new HashMap<>();
        prefixCounts.put(0, 1);
        int prefixSum = 0, count = 0;
        for (int num : nums) {
            prefixSum += num;
            count += prefixCounts.getOrDefault(prefixSum - k, 0);
            prefixCounts.put(prefixSum, prefixCounts.getOrDefault(prefixSum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{1, 1, 1}, 2));
        System.out.println(subarraySum(new int[]{1, -1, 0}, 0));
    }
}
