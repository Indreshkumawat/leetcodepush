class Solution {
    // int solve(int[] nums1, int[] nums2,int m,int n,int i,int j){
    //      if(i >= m || j >= n){
    //         return 0;
    //     }

    //     int take = 0;
    //     int take1 = 0;
    //     int take2 = 0;

    //     if(i < m && j < n && text1.charAt(i) == text2.charAt(j)){
    //         take =  1 + solve(text1,text2,m,n,i+1,j+1);
    //     }
    //     else{
    //         take1 = solve(text1,text2,m,n,i,j+1) ;
    //         take2 = solve(text1,text2,m,n,i+1,j);
    //     }

    //      return Math.max(take,Math.max(take1,take2));

    // }
    public int findLength(int[] nums1, int[] nums2) {
      int m = nums1.length;
      int n = nums2.length;

    //   returnsolve(nums1,nums2,m,n,0,0);
    int maxLen = 0;
    for(int i = 0;i<m;i++){
        for(int j = 0;j<n;j++)
        {
            if(nums1[i] == nums2[j]){
                int count = 0;
                int k = i;
                int w = j;
                while(k < m && w < n && nums1[k] == nums2[w]){
                    count++;
                    k++;
                    w++;
                }
                maxLen = Math.max(maxLen,count);
            }
        }
    }

    return maxLen;
    }
}