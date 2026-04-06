class Solution {
    public boolean isPalindrome(String s) {
        int f = 0;
        int l = s.length()-1;
        while(f < l){
            while(f < l && !alphaNum(s.charAt(f))){
                f++;
            }
            while(f < l && !alphaNum(s.charAt(l))){
                System.out.println("here");
                l--;
            }
            if(Character.toLowerCase(s.charAt(f)) != Character.toLowerCase(s.charAt(l))){
                System.out.print(s.charAt(f));
                return false;
            }
            f++;
            l--;
        }
        return true;
    }
    public boolean alphaNum(char c) {
        return (c >= 'A' && c <= 'Z' ||
                c >= 'a' && c <= 'z' ||
                c >= '0' && c <= '9');
    }
}
