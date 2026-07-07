class Solution {
    public long sumAndMultiply(int n) {
        long sum = 0,x = 0,len = 1;
        while(n!=0){
            x = (n%10)*len+x;
            if(n%10!=0){
                len*=10;
            }
                sum+=n%10;
                n/=10;  

        }
        return sum*x;
    }
}