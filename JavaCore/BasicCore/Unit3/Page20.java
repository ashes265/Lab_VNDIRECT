import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Page20 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Collections.addAll(list, 1, 3, 4, 2, 3, 6, 3, 3, 8);
        System.out.println("Before remove: size=" + list.size());
        list.forEach(v -> {
            if (v == 3) {
                // list.remove();
            }
        });
        System.out.println("After remove: size=" + list.size());
    }
}
