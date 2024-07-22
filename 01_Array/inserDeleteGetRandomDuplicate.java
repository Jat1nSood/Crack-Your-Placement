import java.util.*;

class RandomizedCollection {

    private int n;
    private List<Integer> list;
    private Map<Integer, Set<Integer>> map;

    public RandomizedCollection() {
        this.n = 0;
        this.list = new ArrayList<>();
        this.map = new HashMap<>();
    }
    
    public boolean insert(int val) {
        boolean notContains = !map.containsKey(val);

        if(notContains){
            map.put(val, new HashSet<>());
        }
        map.get(val).add(n);
        list.add(val);
        n++;
        return notContains;
    }
    
    public boolean remove(int val) {
        
        if(n == 0 || !map.containsKey(val)) return false;

        // Getting the index of to be removed value
        int toBeRemovedIndex = map.get(val).iterator().next();
        map.get(val).remove(toBeRemovedIndex);
        if(map.get(val).size() == 0) map.remove(val);

        // Replace the removed lement with last element in the list

        if(toBeRemovedIndex < n - 1){
            int lastElment = list.get(n - 1);
            list.set(toBeRemovedIndex, lastElment);

            map.get(lastElment).remove(n-1);
            map.get(lastElment).add(toBeRemovedIndex);
        }
        list.remove(n-1);
        n--;
        return true;
    }
    
    public int getRandom() {
        if (n == 0) throw new NoSuchElementException();
        int index = (int) (Math.random() * n);
        return list.get(index);
    }
}
