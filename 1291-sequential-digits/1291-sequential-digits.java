class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> ans = new ArrayList<>();
        String digits = "123456789";
        int n = String.valueOf(low).length();
        int m = String.valueOf(high).length();

        for(int len = n;len<=m;len++){
            for(int i = 0;i+len<=9;i++){
                int num = Integer.parseInt(digits.substring(i,i+len));
                if(num>=low && num<=high){
                ans.add(num);
            }
        }
        }
        return ans;
        
    }
}