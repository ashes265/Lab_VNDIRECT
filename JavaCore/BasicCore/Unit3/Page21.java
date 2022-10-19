import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Page21 {
    public static void main(String[] args) {
        List<Integer> list=new ArrayList<>();
        Collections.addAll(list, 1,3,4,2,3,6,3,3,8);
        Iterator<Integer> ite=list.iterator();
        while(ite.hasNext()){
            //cach1
            if(ite.next()==3)ite.remove();
        }
        //cach2 
        list.removeIf(item->{return item==3;});
        //cach3 singleton
        list.removeAll(Collections.singleton(3));
        System.out.println(list);
    }
}
