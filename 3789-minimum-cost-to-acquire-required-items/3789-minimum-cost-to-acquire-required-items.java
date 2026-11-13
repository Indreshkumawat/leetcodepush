class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        if(need1 == 0 && need2 == 0)
            return 0;

        long both = (long) costBoth * Math.max(need1, need2);

        long individual = (long) cost1 * need1 + (long) cost2 * need2;

        long minCost = (long) Math.min(need1, need2) * costBoth;

        long rem = 0;

        if(need1 < need2){
            rem = need2 - need1;
            minCost += rem * cost2;
        }
        else{
            rem = need1 - need2;
            minCost += rem * cost1;
        }

        return Math.min(both, Math.min(individual, minCost));
    }
}