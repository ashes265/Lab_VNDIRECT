import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Page4 {
    public static void main(String[] args) {
        List<String> list=new LinkedList<>();
        for(String ele: args){
            list.add(ele);
        }
        Iterator<String> ite=list.iterator();
        while(ite.hasNext()){
            System.out.println("===>"+ite.next());
        }
    }
}
