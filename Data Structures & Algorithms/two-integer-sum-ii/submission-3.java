class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        int f = 0;
        int l = numbers.length-1;
        while(f < l){
            if(numbers[f] + numbers[l] < target){
                f++;
            }
            else if(numbers[f] + numbers[l] > target){
                l--;
            }
            else{
                result[0] = f+1;
                result[1] = l+1;
                return result;
            }
        }
        return result;
    }
}
