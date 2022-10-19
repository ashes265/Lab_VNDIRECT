import java.util.Comparator;
import java.util.Arrays;
public class Page17{
	public static void main(String[] args){
        Arrays.sort(args);
        for(int i=0;i<args.length;i++){
            System.out.println(args[i]);
        }
        System.out.println("=================");
        Arrays.sort(args,new Comparator<String>(){
            public int compare(String t1,String t2){
                return t2.compareTo(t1);
            }
        });
        for (int i = 0; i < args.length; i++) {
            System.out.println(args[i]);
        }
    }
}