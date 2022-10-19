import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Page12 {
    public static void main(String[] args) {
        List<String> list=new ArrayList<>();
        String[] forList={"Tu","An","Hoa","Binh"};
        Collections.addAll(list, forList);  
        Collections.sort(list);
        list.forEach(hai->{
            System.out.println(hai);
        });
        System.out.println("Vi tri thu "+Collections.binarySearch(list, "An"));

    }
}
