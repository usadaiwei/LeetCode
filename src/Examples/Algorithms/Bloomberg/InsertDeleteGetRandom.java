package Examples.Algorithms.Bloomberg;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class InsertDeleteGetRandom {
    HashMap<Integer, Integer> map; // value, list index
    ArrayList<Integer> list;    // 用list可以从index找value， map只能从value找index， 要一起用互补。
    Random r; // nextInt(10) 就是 从0-9 取任意一个数

    public InsertDeleteGetRandom() {
        map = new HashMap<>();
        list = new ArrayList<>();
        r = new Random();
    }

    public boolean insert(int val) {

        if (map.containsKey(val)){
            return false;
        } else {
            list.add(val);
            map.put(val, list.size()-1);
            return true;
        }
    }

    public boolean remove(int val) {
        if (!map.containsKey(val))
            return false;
        else {
            int index = map.get(val);
            int last = list.get(list.size()-1);
            list.set(index, last);
            map.put(last, index);
            list.remove(list.size()-1);
            map.remove(val);
            return true;
        }
    }

    public int getRandom() {
        return list.get(r.nextInt(list.size()));
    }
}
