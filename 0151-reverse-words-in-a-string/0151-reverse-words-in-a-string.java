class Solution {
    public String reverseWords(String s) {
        String res = "";
        for(int i = s.length()-1;i>=0;i--){
            if(s.charAt(i)==' '){
                continue;
            }
         for (int j = i; j >= 0 && s.charAt(j) != ' '; j--) {
            if (j == 0 || s.charAt(j - 1) == ' ') {
           
        
        String word = s.substring(j,i+1);
        
        if(res.length()==0){
            res = word;
        }
        else{
            res = res +" "+word;
        }
        i = j;
        break;
     }
}
        }
        return res;
    }

}