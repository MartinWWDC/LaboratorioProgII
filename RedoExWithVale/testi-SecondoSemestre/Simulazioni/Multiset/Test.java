import java.util.HashMap;

import java.util.Iterator;

public class Test {
    public static void main(String[] args) {
        HashMap<String,Integer> map=new HashMap<String,Integer>();
        map.put("m",3);
        SMultiSet s=new SMultiSet(map);
        Iterator<String> IT =s.iterator();
        //System.out.println(IT.next());
        System.out.println(s.set.keySet());
    }
}
