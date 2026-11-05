class Solution {
     private int lowerBound(int[] arr, int target) {
        int s = 0, e = arr.length - 1;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (arr[mid] < target)
                s = mid + 1;
            else
                e = mid - 1;
        }
        return s;
    }
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
       Arrays.sort(arr2);
        int count = 0;

        for (int x : arr1) {

            int left = x - d;
            int right = x + d;

            int idx = lowerBound(arr2, left);

            if (idx == arr2.length || arr2[idx] > right) {
                count++;
            }
        }

        return count;
    }
}