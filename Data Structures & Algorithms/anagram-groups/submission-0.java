class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<List<String>>();
        for(int i = 0; i < strs.length; i++){
            if(strs[i] != null){
                List<String> innerList = new ArrayList<String>();
                innerList.add(strs[i]);
                for(int j = i+1; j < strs.length; j++){
                    if(strs[j] != null){
                        String s = strs[i];
                        String t = strs[j];
                        if(s.length() == t.length()){
                            for(int cs = 0; cs < s.length(); cs++){
                                for(int ct = 0; ct < t.length(); ct++){
                                    if(s.charAt(cs) == t.charAt(ct)){
                                        s = s.substring(0,cs) + s.substring(cs+1);
                                        t = t.substring(0,ct) + t.substring(ct+1);
                                        cs--;
                                        break;
                                    }
                                }
                            }
                            if(s.length() == 0 & t.length() == 0){
                                innerList.add(strs[j]);
                                strs[j] = null;
                                
                            } 
                        }
                    }
                }
                result.add(innerList);
            }
        }
        return result;
    }
}
