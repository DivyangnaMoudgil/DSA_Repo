import java.util.ArrayList;
import java.util.List;

public class lc_77 {

    public static List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> result = new ArrayList<>();

        backtrack(
                1,
                n,
                k,
                new ArrayList<>(),
                result
        );

        return result;
    }

    private static void backtrack(
            int start,
            int n,
            int k,
            List<Integer> current,
            List<List<Integer>> result) {

        // Combination is complete
        if (current.size() == k) {

            result.add(new ArrayList<>(current));

            return;
        }

        // Number of elements still needed
        int remaining = k - current.size();

        // Try possible numbers
        for (int i = start; i <= n - remaining + 1; i++) {

            // Choose
            current.add(i);

            // Explore
            backtrack(
                    i + 1,
                    n,
                    k,
                    current,
                    result
            );

            // Undo
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {

        int n = 4;
        int k = 2;

        List<List<Integer>> result = combine(n, k);

        System.out.println(result);
    }
}