package HashTable;

import java.util.*;

class RandomizedSet {
    /**
     * Runtime: 56 ms, faster than 74.66% of Java online submissions for Insert Delete GetRandom O(1).
     * Memory Usage: 44.6 MB, less than 97.69% of Java online submissions for Insert Delete GetRandom O(1).
     */
    Random random;
    List<Integer> list;
    Map<Integer,Integer> map ;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        random = new Random();
        list= new ArrayList<Integer>();
        map = new HashMap<Integer, Integer>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if( map.containsKey(val) ) return false;
        list.add(val);
        map.put(val , list.size()-1);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if( !map.containsKey(val)) return false;
        int index = map.get(val);
        int last = list.size()-1;
        if (index != last){ // 与list中最后一个值做交换
            int v_last = list.get(list.size()-1);
            list.set(index , v_last);
            map.put(v_last , index);
        }
        list.remove(list.size()-1);
        map.remove(val);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}

public class No380RandomizedSet {
    public static void main(String[] args){
        RandomizedSet obj = new RandomizedSet();
        boolean param_0 = obj.insert(1);
        System.out.println(param_0);
        boolean param_1 = obj.insert(2);
        System.out.println(param_1);
        boolean param_2 = obj.remove(2);
        System.out.println(param_2);
        int param_3 = obj.getRandom();
        System.out.println(param_3);
    }
}
