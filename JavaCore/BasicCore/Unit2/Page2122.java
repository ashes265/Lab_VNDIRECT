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
public class Page2122{
	public static void main(String[] args) {
        int max=10000;
        StringBuilder builder=new StringBuilder();
        long start=System.currentTimeMillis();
        for (int i = 0; i < max; i++) {
            builder.append(String.valueOf(i));
        }
        System.out.println("Time 1 = "+(System.currentTimeMillis()-start));
        StringBuffer buffer=new StringBuffer();
        start=System.currentTimeMillis();
        for (int i = 0; i < max; i++) {
            buffer.append(String.valueOf(i));
        }
        System.out.println("Time 2 = "+(System.currentTimeMillis()-start));
        String text="";
        start=System.currentTimeMillis();
        for (int i = 0; i < max; i++){
            text+=String.valueOf(i);
        }
        long end=System.currentTimeMillis();
        System.out.println("Time 3 = "+(end-start));
    }
}