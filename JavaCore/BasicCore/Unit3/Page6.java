import java.util.Set;
import java.util.TreeSet;

public class Page6{
    public static void main(String[] args) {
        Set<Integer> numbers=new TreeSet<Integer>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(8);
        numbers.add(20);
        numbers.add(-5);
        System.out.println("Size of set: "+numbers.size());
    }
}
