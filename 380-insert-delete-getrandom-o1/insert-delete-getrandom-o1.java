class RandomizedSet {
    HashSet<Integer> set;

    public RandomizedSet() {
        set = new HashSet<>();
        
    }
    
    public boolean insert(int val) {
        if(!set.contains(val)){
            set.add(val);
            return true;
        }

        return false;
        
    }
    
    public boolean remove(int val) {
        if(set.contains(val)){
            set.remove(val);
            return true;
        }

        return false;
    }
    
    public int getRandom() {
         List<Integer> integerList = new ArrayList<>(set);

        // Use Random to get a random index
        Random random = new Random();
        int randomIndex = random.nextInt(integerList.size());

        // Get the random integer from the Set
        int randomValue = integerList.get(randomIndex);

        return randomValue;
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */