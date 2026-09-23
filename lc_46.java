import java.util.ArrayList;
import java.util.List;

public class lc_46 {

    public static List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        backtrack(nums, 0, result);

        return result;
    }

    public static void backtrack(
            int[] nums,
            int index,
            List<List<Integer>> result) {

        if (index == nums.length) {

            List<Integer> permutation = new ArrayList<>();

            for (int num : nums) {
                permutation.add(num);
            }

            result.add(permutation);

            return;
        }

        for (int i = index; i < nums.length; i++) {

            swap(nums, index, i);

            backtrack(nums, index + 1, result);

            swap(nums, index, i);
        }
    }

    public static void swap(int[] nums, int i, int j) {

        int temp = nums[i];

        nums[i] = nums[j];

        nums[j] = temp;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3};

        List<List<Integer>> result = permute(nums);

        System.out.println(result);
    }
}