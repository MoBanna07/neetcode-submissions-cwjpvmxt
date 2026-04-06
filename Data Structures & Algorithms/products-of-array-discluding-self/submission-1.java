class Solution {
    public int[] productExceptSelf(int[] nums) { 
        int[] result = new int[nums.length];
        int zeros = 0;
        int mult = 1;
        for(int num : nums){
            if(num == 0){
                zeros++;
            }
            else{
                mult = mult * num;
            }
        }
        if(zeros > 1){
            Arrays.fill(result,0);
            return result;
        }
        if (zeros == 1){
            Arrays.fill(result,0);
            for(int i = 0; i < nums.length; i++){
                if(nums[i] == 0){
                    result[i] = mult;
                    return result;
                }
            }
        }
        for(int i = 0; i < nums.length; i++){
            result[i] = mult/nums[i];
        }
        return result;
    }
}  
