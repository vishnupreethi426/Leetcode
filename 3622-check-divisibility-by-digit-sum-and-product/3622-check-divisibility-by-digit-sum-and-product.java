class Solution {
    public boolean checkDivisibility(int n) {
        int original = n;
        int digit = 0;
        int rem = 0;
        int product = 1;
        while(n>0){
            digit = n%10;
            rem+= digit;
            product*= digit;
            n/=10;
        }
        int res = rem+product;
    return original%res==0;
    }
}