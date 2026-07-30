class Solution {

    int[] leds = {8,4,2,1,32,16,8,4,2,1};

    public List<String> readBinaryWatch(int turnedOn) {

        List<String> ans = new ArrayList<>();

        backtrack(0, turnedOn, 0, 0, ans);

        return ans;
    }

    private void backtrack(int index, int remain, int hour,
                           int minute, List<String> ans) {

        if(hour > 11 || minute > 59)
            return;

        if(remain == 0){

            ans.add(hour + ":" + String.format("%02d", minute));
            return;
        }

        if(index == 10)
            return;

        // Choose current LED
        if(index < 4)
            backtrack(index + 1, remain - 1,
                      hour + leds[index], minute, ans);
        else
            backtrack(index + 1, remain - 1,
                      hour, minute + leds[index], ans);

        // Skip current LED
        backtrack(index + 1, remain, hour, minute, ans);
    }
}