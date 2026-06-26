class Solution {
    public long countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;
        int prefix = n;

        int [] freq = new int[2*n+1];
        freq[n] = 1;

        long count = 0;
        long ans = 0;

        for(int i=0;i<n;i++){
            if(nums[i]==target){
                count+=freq[prefix];
                prefix++;
            }
            else{
                prefix--;
                count-=freq[prefix];
            }
                freq[prefix]++;
                ans+=count;
        }
        return ans;
    }
}