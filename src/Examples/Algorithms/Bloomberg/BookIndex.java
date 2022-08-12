package Examples.Algorithms.Bloomberg;

import java.util.HashMap;
import java.util.Map;

public class BookIndex {

    Map<String, Integer> map1 = new HashMap<>();
    Map<String, Integer> map2 = new HashMap<>();

    String[] one = null;
    String[] two = null;

    public BookIndex(String page1, String page2){
        one = page1.split(" ");
        two = page2.split(" ");

        for (String s : one)
            map1.put(s, (map1.getOrDefault(s, 0) + 1));
        for (String s : two)
            map2.put(s, (map2.getOrDefault(s, 0) + 1));
    }

    public void index(){
        boolean inPage1 = false;
        for (String s : one) {
            if (map1.get(s) > 0) {
                int[] arr1 = new int[map1.get(s)];
                arr1[0] = map1.get(s);
                inPage1 = true;
            }
        }

    }

    public void PopularityIndex(){

    }
}
