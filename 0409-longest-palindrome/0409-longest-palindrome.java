class Solution {
    public int longestPalindrome(String s) {
        int[] freq = new int[128];
        int ans = 0;
        for(char c:s.toCharArray()){
            freq[c]++;
        }
        boolean odd = false;
        for(int count:freq){
            ans+=(count/2)*2;
            if(count%2==1){
                odd = true;
            }
        }
        if(odd){
            ans++;
        }
        return ans;
    }
}