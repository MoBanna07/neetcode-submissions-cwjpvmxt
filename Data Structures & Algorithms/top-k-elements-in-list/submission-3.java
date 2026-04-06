class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        HashMap<Integer,Integer> freq = new HashMap<Integer,Integer>();
        for(int i = 0; i < nums.length; i++){
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
        }
        Set<Integer> keys = new HashSet<>(freq.keySet());
        while(k>0){
            int maxKey = 0;
            int max = -1;
            for(int key: keys){
                if(freq.get(key) != null && freq.get(key) > max){
                    maxKey = key;
                    max = freq.get(key);
                }
            }
            result[k-1] = maxKey;
            keys.remove(maxKey);
            k--;
        }
        return result;
    }
}
