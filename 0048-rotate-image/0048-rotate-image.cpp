class Solution {
public:
    void rotate(vector<vector<int>>& matrix) {
        int m = matrix.size();
        int n = matrix[0].size();
        for(int i=0;i<m;i++) {
            for(int j=i;j<n;j++) {
                if(i != j) {
                   swap(matrix[i][j],matrix[j][i]);
                }
            }
        }
        int k;
        for(int i=0;i<m;i++) {
            k = n-1;
            for(int j =0;j<n;j++) {
                if(k>j){
                swap(matrix[i][j],matrix[i][k--]);
                }
            }
        }
    }
};