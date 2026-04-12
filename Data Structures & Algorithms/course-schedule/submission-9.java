class Solution {
    private HashMap<Integer, List<Integer>> pres = new HashMap<>();
    private Set<Integer> checking = new HashSet<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        for (int i = 0; i < numCourses; i++) {
            pres.put(i, new ArrayList<>());
        }
        for (int[] prereq : prerequisites) {
            pres.get(prereq[0]).add(prereq[1]);
        }

        for(int key : pres.keySet()){
            if(hasLoop(key)){
                return false;
            }
        }

        return true;
    }

    public boolean hasLoop(int key){
        if(checking.contains(key))
            return true;

        if(pres.get(key).isEmpty())
            return false;

        checking.add(key);

        for(int pre : pres.get(key)){
            if(hasLoop(pre)){
                return true;
            }
        }

        checking.remove(key);
        pres.put(key, new ArrayList<>());
        return false;
    }
}
