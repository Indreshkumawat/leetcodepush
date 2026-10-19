class Solution {

    int findFirst(int []nums,int target){
        int s = 0;
        int e = nums.length-1;
        int first = -1;
        while(s <= e){
            int mid = s + (e-s)/2;
            if(nums[mid] == target){
                first = mid;
                e = mid - 1;
            }else if(nums[mid] < target){
                s = mid + 1; 
            }else{
                e = mid - 1;
            }
        }
        return first;
    }
    int findLast(int []nums,int target){
        int s = 0;
        int e = nums.length-1;
        int last = -1;
        while(s <= e){
            int mid = s + (e-s)/2;
            if(nums[mid] == target){
                last = mid;
                s = mid +1;
            }else if(nums[mid] < target){
                s = mid + 1; 
            }else{
                e = mid - 1;
            }
        }
        return last;
    }
    public List<Integer> targetIndices(int[] nums, int target) {
        Arrays.sort(nums);

        List<Integer> ans = new ArrayList<>();

        // for(int i = 0;i<nums.length;i++){
        //     if(nums[i] == target){
        //         ans.add(i);
        //     }
        // }

        int first = findFirst(nums,target);
        int last = findLast(nums,target);

        if(first == -1){
            return ans;
        }

        for(int i = first;i<=last;i++){
            ans.add(i);
        }

        return ans;
    }
}