class Solution {
    public boolean wordPattern(String pattern, String s) {
        HashMap<Character,String> map = new HashMap<>();
        String ch[] = s.trim().split("\\s+");
        if(pattern.length()!=ch.length){
            return false;
        }
        for(int i = 0;i<pattern.length();i++){
            char c = pattern.charAt(i);
            if(map.containsKey(c)){
                if(!map.get(c).equals(ch[i])){
                    return false;
                }
            }
            else{
                if(map.containsValue(ch[i])){
                    return false;
                }
                map.put(c,ch[i]);
            }
        }
        return true;
    }
}