class Solution {

    class Pair {
        int val;
        int index;

        Pair(int val, int index) {
            this.val = val;
            this.index = index;
        }
    }

    int[] count;

    public List<Integer> countSmaller(int[] nums) {

        int n = nums.length;
        count = new int[n];

        Pair[] arr = new Pair[n];

        for (int i = 0; i < n; i++)
            arr[i] = new Pair(nums[i], i);

        mergeSort(arr, 0, n - 1);

        List<Integer> ans = new ArrayList<>();

        for (int x : count)
            ans.add(x);

        return ans;
    }

    private void mergeSort(Pair[] arr, int l, int r) {

        if (l >= r)
            return;

        int mid = (l + r) / 2;

        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, r);

        merge(arr, l, mid, r);
    }

    private void merge(Pair[] arr, int l, int mid, int r) {

        Pair[] temp = new Pair[r - l + 1];

        int i = l;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= r) {

            if (arr[i].val <= arr[j].val) {

                count[arr[i].index] += (j - mid - 1);
                temp[k++] = arr[i++];

            } else {

                temp[k++] = arr[j++];
            }
        }

        while (i <= mid) {
            count[arr[i].index] += (j - mid - 1);
            temp[k++] = arr[i++];
        }

        while (j <= r)
            temp[k++] = arr[j++];

        for (i = l, k = 0; i <= r; i++, k++)
            arr[i] = temp[k];
    }
}