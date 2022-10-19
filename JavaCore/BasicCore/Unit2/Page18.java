import java.util.Arrays;
public class Page18{
	public static void main(String[] args){
        Integer[] values={2,4,7,1,3,5,9,11,3};
        Arrays.sort(values,(Integer i1, Integer i2)->{
            return i2-i1;
        });
        for (int i = 0; i < values.length; i++) {
            System.out.println(values[i]);
        }
    }
}