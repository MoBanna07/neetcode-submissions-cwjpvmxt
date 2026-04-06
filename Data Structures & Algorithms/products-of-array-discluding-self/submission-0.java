class Solution {
    public int[] productExceptSelf(int[] nums) { 
        int[] result = new int[nums.length];
        boolean zero = false;
        for(int i = 0; i < nums.length; i++){
            int mult = 1;
            for(int j = 0; j < nums.length; j++){
                if(i!=j){
                    if(nums[j] != 0){
                        mult = mult * nums[j];
                    }
                    else{
                        mult = 0;
                        break;
                    }
                }
            }
            result[i] = mult;
        }
        return result;
    }
}  
