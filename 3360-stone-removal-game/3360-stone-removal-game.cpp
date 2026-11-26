class Solution {
public:
    bool canAliceWin(int n) {
        if(n < 10){
            return false;
        }  

        int num = 10;

        while(num > 0){
            if(n < num){
                if(num % 2 == 0){
                    return false;
                }
                return true;
            }
            n -= num;
            num--;
        }

        return false;
        
    }
};