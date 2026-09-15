class Solution {
    public boolean canReach(int[] arr, int start) {

        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[arr.length];

        q.add(start);
        visited[start] = true;

        while (!q.isEmpty()) {

            int i = q.poll();

            // Found 0
            if (arr[i] == 0) {
                return true;
            }

            int right = i + arr[i];
            int left = i - arr[i];

            // Move right
            if (right < arr.length && !visited[right]) {
                visited[right] = true;
                q.add(right);
            }

            // Move left
            if (left >= 0 && !visited[left]) {
                visited[left] = true;
                q.add(left);
            }
        }

        return false;
    }
}