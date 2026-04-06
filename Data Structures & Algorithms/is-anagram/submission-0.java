class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() == t.length()){
            for(int i = 0; i < s.length(); i++){
                boolean flag = false;
                for(int j = 0; j < t.length(); j++){
                    if(s.charAt(i) == t.charAt(j)){
                        flag = true;
                        s = s.substring(0,i) + s.substring(i+1);
                        t = t.substring(0,j) + t.substring(j+1);
                        i--;
                        break;
                    }
                }
                if(!flag){
                    return false;
                }
            }
        }
        if(s.length() == 0 && t.length() == 0){
            return true;
        }
        return false;
    }
}
