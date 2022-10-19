import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Page5 {
    public static void main(String[] args) {
        List<String> list=new LinkedList<>(Arrays.asList(args));
        list.forEach(value->{
            System.out.println(value);
        });
    }
}
