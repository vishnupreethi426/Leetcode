class Solution {
    public long gcdSum(int[] nums) {
        int n = nums.length;
        //int[] prefixGcd = new int[n];

        int max = nums[0];

      for (int i = 0; i < n; i++) {
         max = Math.max(max, nums[i]);
           nums[i] = gcd(nums[i], max);
}

        Arrays.sort(nums);
        int i = 0;
        int j = nums.length - 1;
        long sum = 0;
        while(i<j){
          sum+= gcd(nums[i],nums[j]);
          i++;
          j--;  
        }
        return sum;
    }
    private int gcd(int a,int b){
            while(b!=0){
                int temp = a%b;
                a = b;
                b = temp;
            
        }
        return a;
    }
}