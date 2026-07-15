class Solution {
    public int gcdOfOddEvenSums(int n) {

        int sum1 = 0,sum2 = 0;
        for(int i=1;i<=n;i++){
           
                sum1+=i*2-1;
                sum2+=i*2;
            
        }
            while(sum2!=0){
               int s = sum1%sum2;
                sum1 = sum2;
                sum2 = s;

            }
        
        return sum1;
    }
}