class Solution {
    public int snakesAndLadders(int[][] board) {

        int n = board.length;

        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n * n + 1];

        q.add(1);
        visited[1] = true;

        int moves = 0;

        while (!q.isEmpty()) {

            int size = q.size();
            moves++;

            for (int i = 0; i < size; i++) {

                int curr = q.poll();

                for (int dice = 1; dice <= 6; dice++) {

                    int next = curr + dice;

                    if (next > n * n)
                        continue;

                    int[] pos = getPosition(next, n);
                    int r = pos[0];
                    int c = pos[1];

                    // Snake or ladder
                    if (board[r][c] != -1) {
                        next = board[r][c];
                    }

                    if (next == n * n)
                        return moves;

                    if (!visited[next]) {
                        visited[next] = true;
                        q.add(next);
                    }
                }
            }
        }

        return -1;
    }

    private int[] getPosition(int num, int n) {

        int row = n - 1 - (num - 1) / n;
        int col = (num - 1) % n;

        if (((n - 1 - row) % 2) == 1) {
            col = n - 1 - col;
        }

        return new int[]{row, col};
    }
}