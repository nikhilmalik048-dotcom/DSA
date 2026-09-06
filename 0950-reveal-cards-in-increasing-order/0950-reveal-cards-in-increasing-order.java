class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {

        Arrays.sort(deck);

        int n = deck.length;
        int[] ans = new int[n];

        Queue<Integer> q = new LinkedList<>();

        // Store indexes
        for (int i = 0; i < n; i++) {
            q.add(i);
        }

        for (int card : deck) {

            // Position for current smallest card
            int index = q.remove();

            ans[index] = card;

            // Move next position to back
            if (!q.isEmpty()) {
                q.add(q.remove());
            }
        }

        return ans;
    }
}