class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalFuel = 0;
        int currFuel = 0;
        int start=0;
        for(int i=0;i<gas.length;i++){
            int diff= gas[i]-cost[i];
            totalFuel = totalFuel+diff;
            currFuel= currFuel+diff;
            if(currFuel<0){
                start= i+1; //chage the station
                currFuel=0;//reset currFuel
            }
        }
        if(totalFuel<0){
            return -1;
        }
        return start;
        
    }
}