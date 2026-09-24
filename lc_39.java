import java.util.ArrayList;
import java.util.List;

public class lc_39 {

    public static List<List<Integer>> combinationSum(
            int[] candidates,
            int target) {

        List<List<Integer>> result = new ArrayList<>();

        backtrack(
                candidates,
                target,
                0,
                new ArrayList<>(),
                result
        );

        return result;
    }

    private static void backtrack(
            int[] candidates,
            int target,
            int start,
            List<Integer> current,
            List<List<Integer>> result) {

        // Target reached
        if (target == 0) {

            result.add(new ArrayList<>(current));

            return;
        }

        // Try all possible candidates
        for (int i = start; i < candidates.length; i++) {

            // Skip if candidate is larger than target
            if (candidates[i] > target) {
                continue;
            }

            // Choose
            current.add(candidates[i]);

            // Explore
            // Same number can be used again
            backtrack(
                    candidates,
                    target - candidates[i],
                    i,
                    current,
                    result
            );

            // Undo
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {

        int[] candidates = {2, 3, 6, 7};

        int target = 7;

        List<List<Integer>> result =
                combinationSum(candidates, target);

        System.out.println(result);
    }
}