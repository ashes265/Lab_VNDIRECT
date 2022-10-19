import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;

public class Page10 {
    public static void main(String[] args) {
        TreeMap<Integer,String> map=new TreeMap<>();
        map.put(3, "Nguyen Van A");
        map.put(1, "Nguyen Van B");
        map.put(5, "Nguyen Van C");
        map.put(4, "Nguyen Van X");
        Iterator<Entry<Integer, String>> iterator=map.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<Integer,String> entry=iterator.next();
            System.out.println(entry.getKey()+" : "+entry.getValue());
        }
        System.out.println("Cach 2");
        map.descendingKeySet().forEach(key->
        {
            System.out.println("Key = "+key+" value ="+map.get(key));
        }
        );
    }
}
