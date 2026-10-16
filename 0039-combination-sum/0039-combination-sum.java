import java.util.*;

class Solution {

    public void solve(int[] candidates, int target,
                      List<List<Integer>> res,
                      List<Integer> temp,
                      int ind) {

        if (target < 0 || ind >= candidates.length) {
            return;
        }

        if (target == 0) {
            res.add(new ArrayList<>(temp));
            return;
        }

        if (candidates[ind] <= target) {
            temp.add(candidates[ind]);

            solve(candidates, target - candidates[ind], res, temp, ind);

            temp.remove(temp.size() - 1);
        }

        solve(candidates, target, res, temp, ind + 1);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        solve(candidates, target, res, temp, 0);

        return res;
    }
}