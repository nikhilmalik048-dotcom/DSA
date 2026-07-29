class Solution {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> ans = new ArrayList<>();
        backtrack(0, candidates, target, new ArrayList<>(), ans);
        return ans;
    }

    private void backtrack(int index, int[] arr, int target,
                           List<Integer> curr,
                           List<List<Integer>> ans) {

        if (target == 0) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        if (index == arr.length || target < 0)
            return;

        // Pick
        curr.add(arr[index]);
        backtrack(index, arr, target - arr[index], curr, ans);

        curr.remove(curr.size() - 1);

        // Not Pick
        backtrack(index + 1, arr, target, curr, ans);
    }
}