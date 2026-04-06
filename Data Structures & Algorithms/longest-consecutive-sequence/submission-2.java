class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> seq = new HashSet<Integer>();
        for(int num: nums){
            seq.add(num);
        }
        int longestConSeq = 0;
        for(int num: seq){
            int length = 1;
            if(!seq.contains(num-1)){
                while(seq.contains(num + length)){
                    length++;
                }
                longestConSeq = Integer.max(longestConSeq, length);
            }
        }
        return longestConSeq;
    }
}
