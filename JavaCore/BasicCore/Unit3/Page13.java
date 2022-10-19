import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Page13 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(4, 7, 1, 3, 8, 9, 2, 6, 10));
        Comparator<Integer> compare = new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        };
        Comparator<Integer> compare2=Integer::compare;
        Collections.sort(list, compare2);
        System.out.println(list);
        list.stream().filter(hai -> hai > 5).forEach(hai -> {
            System.out.println(hai);
        });
    }
}
