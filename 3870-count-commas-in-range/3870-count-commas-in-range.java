class Solution {
    public int countCommas(int n) {
        int count = 0;
        for(int i=1;i<=n;i++){
            if(i>=1000 && i<=999999){
                count++;
            }
        }
        return count;
    }
}