import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Page3{
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        Collections.addAll(list, args);
        for (int i = 0; i < list.size(); i++) {
            System.out.println("Element at " + i + " is " + list.get(i));
        }
    }
}