class Solution {
    long solve(int[] time,long givenTime){
        long trips = 0;
        for(int i = 0;i<time.length;i++){
            trips += givenTime/time[i];
        }

        return trips;
    }
    public long minimumTime(int[] time, int totalTrips) {
        long min = time[0];

        for(int i = 0;i<time.length;i++){
            min = Math.min(min,time[i]);
        }
        long s = 1;
        long e = min * totalTrips;
        long ans = e;
        while(s <= e){
            long mid = s + (e-s)/2;
            
            long doneTrips = solve(time,mid);
            
            if(doneTrips >= totalTrips){
                ans = Math.min(mid,ans);
                e = mid - 1;
            }else{
                s = mid + 1;
            }
        } 

        return ans;

    }
}