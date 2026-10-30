class Solution {
    public int maximumSum(int[] arr) {
       int noDeletion = arr[0];
        int oneDeletion = 0;
        int ans = arr[0];

        for (int i = 1; i < arr.length; i++) {
            oneDeletion = Math.max(noDeletion, oneDeletion + arr[i]);
            noDeletion = Math.max(arr[i], noDeletion + arr[i]);

            ans = Math.max(ans, Math.max(noDeletion, oneDeletion));
        }

        return ans;
    }
}