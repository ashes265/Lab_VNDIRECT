import java.io.IOException;
import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import static java.util.Calendar.DATE;
import java.util.Comparator;
import java.util.Locale;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;
import java.util.prefs.Preferences;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Page19{
	public static void main(String[] args){
        Integer[] values={2,4,7,1,3,5,9,11,3};
        Arrays.sort(values,(Integer i1, Integer i2)->{
            return i2-i1;
        });
        Stream<Integer> stream=Arrays.stream(values);
//        stream.forEach(value -> System.out.println(value));
        Optional<Integer> max=stream.max((Integer o1,Integer o2)->{
            return o1-o2;
        });
        System.out.println("Gia tri lon nhat: "+max.get());
        stream=Arrays.stream(values);
        Predicate<Integer> predicate =(Integer value)-> {return value > 5;};
        Stream<Integer> older =stream.filter(predicate);
        older.forEach((Integer value)->{
            System.out.println(value);
        });
    }
}