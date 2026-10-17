class Solution {
    int sum(int num){
        int ans = 0;
        while(num > 0){
            int digit = num%10;
            ans+=digit;
            num /=10;
        }

        return ans;
    }
    public int minSwaps(int[] nums) {
        int n = nums.length;

        List<Integer> arr = new ArrayList<>(nums.length);
        for (int num : nums) {
            arr.add(num);
        }

        ArrayList<Integer> sorted = new ArrayList<>(arr);
        Collections.sort(sorted ,(a,b)->{
            int sumA = sum(a);
            int sumB = sum(b);
            if(sumA != sumB){
                return Integer.compare(sumA,sumB);
            }else{
                return Integer.compare(a,b);
            }
        });

        HashMap<Integer, Integer> mp = new HashMap<>();

        for (int i = 0; i < n; i++) {
            mp.put(arr.get(i), i);
        }

        int swaps = 0;

        for (int i = 0; i < n; i++) {
            if (arr.get(i) == sorted.get(i)) {
                continue;
            }
            int correctIndex = mp.get(sorted.get(i));
            int currValue = arr.get(i);
            int correctValue = arr.get(correctIndex);

            Collections.swap(arr, correctIndex, i);

            mp.put(currValue, correctIndex);
            mp.put(correctValue, i);

            swaps++;
        }

         System.out.print(swaps);
         return swaps;
    }
}