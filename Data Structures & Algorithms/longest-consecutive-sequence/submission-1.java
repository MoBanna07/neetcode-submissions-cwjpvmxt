class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        HashSet<Integer> seq = new HashSet<Integer>();
        int min = nums[0];
        int max = nums[0];
        for(int num: nums){
            min = Integer.min(num, min);
            max = Integer.max(num, max);
            seq.add(num);
        }
        int longestConSeq = 0;
        int conSeq = 0;
        for(int i = min; i <= max; i++){
            if(seq.contains(i)){
                conSeq++;
                longestConSeq = Integer.max(longestConSeq, conSeq);
            }
            else{
                conSeq = 0; 
            }              
        }
        return longestConSeq;
    }
}
