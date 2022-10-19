import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;
public class Page11{
	public static int CountDigit(String value){
        AtomicInteger counter=new AtomicInteger(0);
        IntStream stream=value.chars();
        stream.forEach(c->{
            if(Character.isDigit(c)){
                counter.incrementAndGet();
            }
        });
        return counter.get();
    }
public static void main(String[] args) {
	String x=args.toString();
        System.out.println(CountDigit(x));
    }	
}