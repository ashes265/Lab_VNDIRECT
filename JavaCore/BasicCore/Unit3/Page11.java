import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Page11 {
    public static void main(String[] args) {
        Short[] values = { 1, 2, 4, 5, 6, 7, 8, 9 };
        List<Short> list = new ArrayList<>();
        Collections.addAll(list, values);
        Collections.reverse(list);
        Collections.sort(list);
        list.toArray(values);
        // for (int i = 0; i < values.length; i++) {
        // System.out.print(values[i]+",");
        // }
        System.out.println(values[0].shortValue());
        System.out.println(Collections.max(list));
        System.out.println(list);
        System.out.println("Vi tri:" + Collections.binarySearch(list, (short) 5));
    }
}
